package org.evertones.controller;

import org.evertones.model.cashflow.Period;
import org.evertones.persistence.cashflow.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PeriodController {

    private PeriodRepository periodRepository;

    @Autowired
    public void setPeriodRepository(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    @RequestMapping(path = "/period/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("periods", periodRepository.findAll());

        return "/period/list";
    }

    @RequestMapping(path = "/period/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") String id) {
        model.addAttribute("period", periodRepository.findOne(Integer.valueOf(id)));

        return "/period/edit";
    }

    @RequestMapping(path = "/period/edit", method = RequestMethod.GET)
    public String edit(Model model) {
        model.addAttribute("period", new Period());
        return "/period/edit";
    }

    @RequestMapping(path = "/period/add", method = RequestMethod.POST)
    public String submit(Period period) {
        periodRepository.save(period);

        return "redirect:/period/list";
    }

}
