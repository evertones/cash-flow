package org.evertones.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

@Controller
class IndexController {

    @RequestMapping(path = Array("/"), method = Array(RequestMethod.GET))
    def get(): String = {
        "index"
    }

    @RequestMapping(path = Array("/index"), method = Array(RequestMethod.GET))
    def getIndex: String = {
        "index"
    }

    @RequestMapping(path = Array("/login"), method = Array(RequestMethod.GET))
    def getLogin: String = {
        "login"
    }

    @RequestMapping(path = Array("/construction"), method = Array(RequestMethod.GET))
    def getConstruction: String = {
        "underConstruction"
    }

}
