package org.evertones.controller;

import org.evertones.model.cashflow.Item;
import org.evertones.persistence.cashflow.DefaultItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

    private DefaultItemRepository itemRepository;

    @Autowired
    public void setItemRepository(DefaultItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(path = "/item/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "/item/list";
    }

    @RequestMapping(path = "/item/add", method = RequestMethod.GET)
    public String edit(Model model) {
        model.addAttribute("item", new Item());
        return "/item/edit";
    }

    @RequestMapping(path = "/item/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("item", itemRepository.findOne(id));
        return "/item/edit";
    }

    @RequestMapping(path = "/item/add", method = RequestMethod.POST)
    public String submit(Item item) {
        itemRepository.save(item);
        return "redirect:/item/list";
    }

    @RequestMapping(path = "/item/active/toggle/{id}", method = RequestMethod.GET)
    public String updateActive(@PathVariable(name = "id") String id) {
        Item item = itemRepository.findOne(Integer.valueOf(id));

        if (item.getActive()) item.setActive(false);
        else item.setActive(true);

        itemRepository.save(item);

        return "redirect:/item/list";
    }

    @RequestMapping(path = "/item/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(name = "id") Integer id) {
        itemRepository.delete(id);
        return "redirect:/item/list";
    }

}
