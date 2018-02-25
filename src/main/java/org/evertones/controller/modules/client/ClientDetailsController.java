package org.evertones.controller.modules.client;

import org.evertones.model.modules.client.Client;
import org.evertones.model.modules.client.ClientDetails;
import org.evertones.persistence.modules.client.ClientDetailsRepository;
import org.evertones.persistence.modules.client.ClientDetailsService;
import org.evertones.persistence.modules.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

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

    @RequestMapping(path = "/model/add/{id}", method = RequestMethod.GET)
    public String addModel(Model model, @PathVariable(name = "id") Integer id) {
        Client client = clientRepository.findOne(id);
        ClientDetails clientDetails = new ClientDetails().setClient(client);

        model.addAttribute("person", clientDetails);
        return "client/model/edit";
    }

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

}
