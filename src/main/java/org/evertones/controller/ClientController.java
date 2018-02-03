package org.evertones.controller;

import org.evertones.model.client.Client;
import org.evertones.persistence.client.ClientRepository;
import org.evertones.persistence.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(path = "/client/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("client", clientRepository.findOne(id));
        return "/client/edit";
    }

    @RequestMapping(path = "/client/add", method = RequestMethod.POST)
    public String submit(Client client) {
        clientService.save(client);
        return "redirect:/client/edit/"+client.getId();
    }

    @RequestMapping(path = "/client/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {

        // TODO: Fix the bug when filtering data by the MONTH
//        List<Client> currentMonth  = clientService.findByMonthOfBirth(LocalDate.now().getMonth());
//        List<Client> previousMonth = clientService.findByMonthOfBirth(LocalDate.now().getMonth().minus(1L));
//        List<Client> nextMonth     = clientService.findByMonthOfBirth(LocalDate.now().getMonth().plus(1L));

        List<Client> currentMonth  = clientRepository.findAll();
        List<Client> previousMonth = clientRepository.findAll();
        List<Client> nextMonth     = clientRepository.findAll();

        model.addAttribute("currentMonth",  currentMonth);
        model.addAttribute("nextMonth",     previousMonth);
        model.addAttribute("previousMonth", nextMonth);

        return "/client/dashboard";
    }

}
