package org.evertones.controller;

import org.evertones.model.client.Client;
import org.evertones.persistence.client.ClientRepository;
import org.evertones.persistence.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController {

    ClientRepository clientRepository;
    ClientService    clientService;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
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

        attributes.addFlashAttribute("flashMessage", "Success");
        attributes.addFlashAttribute("cssClass", "alert alert-success");

        return String.format("redirect:/client/add/%s", client.getId().toString());
    }

    @RequestMapping(path = "/client/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {
        List<Client> currentMonth  = clientService.findByMonthOfBirth(LocalDate.now().getMonth());
        List<Client> previousMonth = clientService.findByMonthOfBirth(LocalDate.now().getMonth().minus(1L));
        List<Client> nextMonth     = clientService.findByMonthOfBirth(LocalDate.now().getMonth().plus(1L));

        model.addAttribute("currentMonth",  currentMonth);
        model.addAttribute("nextMonth",     previousMonth);
        model.addAttribute("previousMonth", nextMonth);

        return "/client/dashboard";
    }

    @RequestMapping(path = "/client/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("clients", new ArrayList<Client>());

        return "/client/list";
    }

    @RequestMapping(path = "/client/list", method = RequestMethod.POST)
    public String listResults(Client client, BindingResult bindingResult, Model model) {
        List<Client> list = clientService.findAll(client);

        model.addAttribute("client", client);
        model.addAttribute("clients", list);

        return "/client/list";
    }

}
