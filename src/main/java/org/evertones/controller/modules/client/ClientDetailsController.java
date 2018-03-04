package org.evertones.controller.modules.client;

import org.evertones.controller.dto.ClientDashboardDto;
import org.evertones.model.modules.client.Client;
import org.evertones.model.modules.client.ClientDetails;
import org.evertones.model.types.ClientType;
import org.evertones.persistence.modules.client.ClientDetailsRepository;
import org.evertones.persistence.modules.client.ClientDetailsService;
import org.evertones.persistence.modules.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/client")
public class ClientDetailsController {

    private ClientRepository clientRepository;

    private ClientDetailsRepository clientDetailsRepository;
    private ClientDetailsService clientDetailsService;

    private MessageSource messageSource;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setClientDetailsRepository(ClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Autowired
    public void setClientDetailsService(ClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Method to add a model linked to a client id.
     * The URL receives the {id} parameter with the client id.
     **/
    @RequestMapping(path = "/model/add/{id}", method = RequestMethod.GET)
    public String addModel(Model model, @PathVariable(name = "id") Integer id) {
        Client client = clientRepository.findOne(id);
        ClientDetails clientDetails = new ClientDetails().setClient(client);

        model.addAttribute("person", clientDetails);
        return "client/model/edit";
    }

    /**
     * Method to edit a model.
     * The URL receives the {id} parameter with the model id.
     **/
    @RequestMapping(path = "/model/edit/{id}", method = RequestMethod.GET)
    public String editModel(Model model, @PathVariable(name = "id") Integer id) {
        ClientDetails clientDetails = clientDetailsRepository.findOne(id);

        model.addAttribute("person", clientDetails);
        return "client/model/edit";
    }

    @RequestMapping(path = "/model/add", method = RequestMethod.POST)
    public String submitModel(ClientDetails clientDetails, RedirectAttributes attributes) {
        clientDetailsService.save(clientDetails);

        // TODO: 1) Get the default locale; 2) add values for CSS classes in an Enum
        Locale defaultLocale = new Locale("pt");
        attributes.addFlashAttribute("flashMessage", messageSource.getMessage("module.general.saveSuccess.message", null, defaultLocale));
        attributes.addFlashAttribute("cssClass", "alert alert-success");

        return String.format("redirect:edit/%s", clientDetails.getId().toString());

    }

    @RequestMapping(path = "/model/delete/{id}", method = RequestMethod.GET)
    public String deleteModel(Model model, @PathVariable(name = "id") Integer id) {
        Client client = clientDetailsRepository.findOne(id).getClient();
        //model.addAttribute("client", new Client());
        clientDetailsRepository.delete(id);

        return String.format("redirect:../../add/%s", client.getId().toString());
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("client", new ClientDetails());
        model.addAttribute("clients", new ArrayList<ClientDetails>());
        model.addAttribute("clientType", ClientType.class);

        return "client/search";
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String listResults(ClientDetails clientDetails, ClientType clientType, BindingResult bindingResult, Model model) {
        List<ClientDetails> list = clientDetailsService.findAllByClientType(clientDetails, clientType);

        model.addAttribute("client", clientDetails);
        model.addAttribute("clients", list);
        model.addAttribute("clientType", clientType);

        return "client/search";
    }

    @RequestMapping(path = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {
        LocalDate now = LocalDate.now();

        List<ClientDashboardDto> currentMonth  = buildOutput(clientDetailsService.findByMonthOfBirth(now.getMonth()));
        List<ClientDashboardDto> previousMonth = buildOutput(clientDetailsService.findByMonthOfBirth(now.getMonth().minus(1L)));
        List<ClientDashboardDto> nextMonth     = buildOutput(clientDetailsService.findByMonthOfBirth(now.getMonth().plus(1L)));

        model.addAttribute("currentMonth",  currentMonth);
        model.addAttribute("nextMonth",     nextMonth);
        model.addAttribute("previousMonth", previousMonth);

        return "client/dashboard";
    }

    private List<ClientDashboardDto> buildOutput(List<ClientDetails> clients) {
        Comparator<ClientDashboardDto> byDayOfMonth = (ClientDashboardDto c1, ClientDashboardDto c2) ->
                c1.getDayOfMonth().compareTo(c2.getDayOfMonth());

        List<ClientDashboardDto> clientsDashboardDto = new ArrayList<ClientDashboardDto>();
        clients.forEach(client -> {
            clientsDashboardDto.add(new ClientDashboardDto(
                            client.getName(),
                            client.getBirthday(),
                            client.getClient() == null ? ClientType.CLIENT : ClientType.CLIENT
                    )
            );
        });

        return clientsDashboardDto.stream().sorted(byDayOfMonth).collect(Collectors.toList());
    }


}
