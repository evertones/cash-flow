package org.evertones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
public class SystemController {

    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(path = "/system/test", method = RequestMethod.GET)
    public String testPage(Model model) {
        model.addAttribute("message_en", messageSource.getMessage("message", null, Locale.US));
        model.addAttribute("message_pt", messageSource.getMessage("message", null, new Locale("pt")));
        return "system/test";
    }



}
