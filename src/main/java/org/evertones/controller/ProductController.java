package org.evertones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @RequestMapping(path = "product/add", method = RequestMethod.GET)
    public String add() {
        return "product/edit";
    }

}
