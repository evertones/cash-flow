package org.evertones.controller

import java.util.Locale

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}

@Controller
@RequestMapping(path = Array("/system"))
class SystemController {

    private var messageSource: MessageSource = _

    @Autowired
    def setMessageSource(messageSource: MessageSource): Unit = {
        this.messageSource = messageSource
    }

    @RequestMapping(path = Array("/test"), method = Array(RequestMethod.GET))
    def testPage(model: Model): String = {
        model.addAttribute("message_en", messageSource.getMessage("message", null, Locale.US))
        model.addAttribute("message_pt", messageSource.getMessage("message", null, new Locale("pt")))

        "system/test"
    }



}
