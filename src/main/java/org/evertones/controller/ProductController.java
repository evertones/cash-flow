package org.evertones.controller;

import org.evertones.model.product.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @RequestMapping(path = "/product/list", method = RequestMethod.GET)
    public String list() {
        return "/product/list";
    }

    @RequestMapping(path = "/product/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("product", new Product());

        return "/product/edit";
    }

}
