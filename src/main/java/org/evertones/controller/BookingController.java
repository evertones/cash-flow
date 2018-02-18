package org.evertones.controller;

import org.evertones.model.service.Booking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingController {

    @RequestMapping(path = "/booking/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("booking", new Booking());

        return "/booking/edit";
    }

}
