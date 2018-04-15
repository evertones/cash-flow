package org.evertones.controller.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class BadRequestController {

    private static Logger logger = LoggerFactory.getLogger(BadRequestController.class);

    @RequestMapping(path = "/403", method = RequestMethod.GET)
    public String error403(Principal principal) {
        logger.info("User"  + principal.getName());
        return "error/403";
    }

}
