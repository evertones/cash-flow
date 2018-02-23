package org.evertones.controller;

import org.evertones.controller.dto.ClientDashboardDto;
import org.evertones.model.client.Client;
import org.evertones.persistence.client.ClientRepository;
import org.evertones.persistence.client.ClientService;
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
public class ClientController {

    private ClientRepository clientRepository;
    private ClientService    clientService;
    private MessageSource    messageSource;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(path = "/client/add", method = RequestMethod.GET)
    public String edit(Model model) {
        model.addAttribute("client", new Client());
        return "/client/edit";
    }

    @RequestMapping(path = "/client/add/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("client", clientRepository.findOne(id));
        return "/client/edit";
    }

    @RequestMapping(path = "/client/add", method = RequestMethod.POST)
    public String submit(Client client, RedirectAttributes attributes) {
        clientService.save(client);

        // TODO: 1) Get the default locale; 2) add values for CSS classes in an Enum
        Locale defaultLocale = new Locale("pt");
        attributes.addFlashAttribute("flashMessage", messageSource.getMessage("module.general.saveSuccess.message", null, defaultLocale));
        attributes.addFlashAttribute("cssClass", "alert alert-success");

        return String.format("redirect:/client/add/%s", client.getId().toString());
    }

    @RequestMapping(path = "/client/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {
        LocalDate now = LocalDate.now();

        List<ClientDashboardDto> currentMonth  = buildOutput(clientService.findByMonthOfBirth(now.getMonth()));
        List<ClientDashboardDto> previousMonth = buildOutput(clientService.findByMonthOfBirth(now.getMonth().minus(1L)));
        List<ClientDashboardDto> nextMonth     = buildOutput(clientService.findByMonthOfBirth(now.getMonth().plus(1L)));

        model.addAttribute("currentMonth",  currentMonth);
        model.addAttribute("nextMonth",     nextMonth);
        model.addAttribute("previousMonth", previousMonth);

        return "/client/dashboard";
    }

    private List<ClientDashboardDto> buildOutput(List<Client> clients) {
        Comparator<ClientDashboardDto> byDayOfMonth = (ClientDashboardDto c1, ClientDashboardDto c2) ->
                c1.getDayOfMonth().compareTo(c2.getDayOfMonth());

        List<ClientDashboardDto> clientsDashboardDto = new ArrayList<ClientDashboardDto>();
        clients.forEach(client -> {
            clientsDashboardDto.add(new ClientDashboardDto(
                    client.getClient().getName(),
                    client.getClient().getBirthday(),
                    null
                    )
            );
        });

        return clientsDashboardDto.stream().sorted(byDayOfMonth).collect(Collectors.toList());
    }

    @RequestMapping(path = "/client/search", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("clients", new ArrayList<Client>());

        return "/client/search";
    }

    @RequestMapping(path = "/client/search", method = RequestMethod.POST)
    public String listResults(Client client, BindingResult bindingResult, Model model) {
        List<Client> list = clientService.findAll(client);

        model.addAttribute("client", client);
        model.addAttribute("clients", list);

        return "/client/search";
    }

    @RequestMapping(path = "/client/delete/{id}")
    public String delete(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("client", new Client());
        clientRepository.delete(id);

        return "/client/search";
    }

}
