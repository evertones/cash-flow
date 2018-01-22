package org.evertones.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class BadRequestController {

    @RequestMapping(path = "/403", method = RequestMethod.GET)
    public String error403(Principal principal) {
        System.out.println("User"  + principal.getName());
        return "/error/403";
    }

}
