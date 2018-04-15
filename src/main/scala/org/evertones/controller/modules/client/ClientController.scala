package org.evertones.controller.modules.client

import org.evertones.controller.BaseController
import org.evertones.controller.dto.MessageDto
import org.evertones.model.modules.client.{Client, ClientDetails}
import org.evertones.persistence.modules.client.{ClientDetailsRepository, ClientRepository, ClientService}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestMethod}
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import scala.collection.JavaConverters._

@Controller
@RequestMapping(path = Array("/client"))
class ClientController extends BaseController {

    private var clientRepository       : ClientRepository        = _
    private var clientService          : ClientService           = _
    private var clientDetailsRepository: ClientDetailsRepository = _

    @Autowired
    def setClientRepository(clientRepository: ClientRepository): Unit = {
        this.clientRepository = clientRepository
    }

    @Autowired
    def setClientService(clientService: ClientService): Unit = {
        this.clientService = clientService
    }

    @Autowired
    def setClientDetailsRepository(clientDetailsRepository: ClientDetailsRepository): Unit = {
        this.clientDetailsRepository = clientDetailsRepository
    }

    @RequestMapping(path = Array("/add"), method = Array(RequestMethod.GET))
    def edit(model: Model): String = {
        model.addAttribute("clientModels", List[ClientDetails]().asJava)
        model.addAttribute("client", new Client())

        "client/edit"
    }

    @RequestMapping(path = Array("/add/{id}"), method = Array(RequestMethod.GET))
    def edit(model: Model, @PathVariable(name = "id") id: Int): String = {
        val client: Client = clientRepository.findOne(id)

        model.addAttribute("clientModels", client.getModels)
        model.addAttribute("client", client)

        "client/edit"
    }

    @RequestMapping(path = Array("/add"), method = Array(RequestMethod.POST))
    def submit(client: Client, attributes: RedirectAttributes): String = {
        clientService.save(client)

        // TODO: add values for CSS classes in an Enum
        attributes.addFlashAttribute("flashMessage",
            messageSource.getMessage("module.general.saveSuccess.message", null, BaseController.DEFAULT_LOCALE))
        attributes.addFlashAttribute("cssClass", "alert alert-success")

        "redirect:add/%s".format(client.getId.toString)
    }

    @RequestMapping(path = Array("/editByDetail/{id}"))
    def delete(model: Model, @PathVariable(name = "id") id: Int): String = {

        val clientDetails: ClientDetails = clientDetailsRepository.findOne(id)
        val client       : Client        = clientService.findByClientDetails(clientDetails)

        "redirect:../add/%s".format(client.getId)
    }

    @RequestMapping(path = Array("/deleteByDetail/{id}"))
    def deleteByClientDetails(model: Model, @PathVariable(name = "id") id: Int): String = {
        model.addAttribute("client", new Client())

        val clientDetails: ClientDetails = clientDetailsRepository.findOne(id)
        val client       : Client        = clientService.findByClientDetails(clientDetails)
        clientRepository.delete(client)

        val flashMessage: MessageDto = new MessageDto()
                .setCssClass("alert alert-success")
                .setMessage(messageSource.getMessage("module.general.deleteSuccess.message", null, BaseController.DEFAULT_LOCALE))

        model.addAttribute("flashMessage", flashMessage)

        "redirect:../search"
    }

}
