package org.evertones.controller.modules.client;

import org.evertones.controller.dto.MessageDto;
import org.evertones.model.modules.client.Client;
import org.evertones.model.modules.client.ClientDetails;
import org.evertones.persistence.modules.client.ClientDetailsRepository;
import org.evertones.persistence.modules.client.ClientRepository;
import org.evertones.persistence.modules.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(path = "/client")
public class ClientController {

    private static final Locale DEFAULT_LOCALE = new Locale("pt");

    private ClientRepository clientRepository;
    private ClientService    clientService;
    private ClientDetailsRepository clientDetailsRepository;

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

    @Autowired
    public void setClientDetailsRepository(ClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String edit(Model model) {
        model.addAttribute("clientModels", new ArrayList<ClientDetails>());
        model.addAttribute("client", new Client());
        return "client/edit";
    }

    @RequestMapping(path = "/add/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Integer id) {
        Client client = clientRepository.findOne(id);
        model.addAttribute("clientModels", client.getModels());
        model.addAttribute("client", client);
        return "client/edit";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String submit(Client client, RedirectAttributes attributes) {
        clientService.save(client);

        // TODO: 1) Get the default locale; 2) add values for CSS classes in an Enum
        attributes.addFlashAttribute("flashMessage", messageSource.getMessage("module.general.saveSuccess.message", null, DEFAULT_LOCALE));
        attributes.addFlashAttribute("cssClass", "alert alert-success");

        return String.format("redirect:add/%s", client.getId().toString());
    }

    @RequestMapping(path = "/editByDetail/{id}")
    public String delete(Model model, @PathVariable(name = "id") Integer id) {

        ClientDetails clientDetails = clientDetailsRepository.findOne(id);
        Client client = clientService.findByClientDetails(clientDetails);

        return String.format("redirect:../add/%s", client.getId());
    }

    @RequestMapping(path = "/deleteByDetail/{id}")
    public String deleteByClientDetails(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("client", new Client());

        ClientDetails clientDetails = clientDetailsRepository.findOne(id);
        Client client = clientService.findByClientDetails(clientDetails);
        clientRepository.delete(client);

        MessageDto flashMessage = new MessageDto()
                .setCssClass("alert alert-success")
                .setMessage(messageSource.getMessage("module.general.deleteSuccess.message", null, DEFAULT_LOCALE));

        model.addAttribute("flashMessage", flashMessage);

        return "redirect:../search";
    }



}
