package org.evertones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String get() {
        return "index";
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

}
