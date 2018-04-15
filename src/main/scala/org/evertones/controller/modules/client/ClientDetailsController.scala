package org.evertones.controller.modules.client

import java.time.LocalDate
import java.util

import org.evertones.controller.BaseController
import org.evertones.controller.dto.ClientDashboardDto
import org.evertones.model.modules.client.ClientDetails
import org.evertones.model.types.ClientType
import org.evertones.persistence.modules.client.{ClientDetailsRepository, ClientDetailsService, ClientRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestMethod}
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer

@Controller
@RequestMapping(path = Array("/client"))
class ClientDetailsController extends BaseController {

    private var clientRepository        : ClientRepository        = _
    private var clientDetailsRepository : ClientDetailsRepository = _
    private var clientDetailsService    : ClientDetailsService    = _

    @Autowired
    def setClientRepository(clientRepository: ClientRepository): Unit = {
        this.clientRepository = clientRepository
    }

    @Autowired
    def setClientDetailsRepository(clientDetailsRepository: ClientDetailsRepository): Unit = {
        this.clientDetailsRepository = clientDetailsRepository
    }

    @Autowired
    def setClientDetailsService(clientDetailsService: ClientDetailsService): Unit = {
        this.clientDetailsService = clientDetailsService
    }

    /**
      * Method to add a model linked to a client id.
      * The URL receives the {id} parameter with the client id.
      **/
    @RequestMapping(path = Array("/model/add/{id}"), method = Array(RequestMethod.GET))
    def addModel(model: Model, @PathVariable(name = "id") id: Int): String = {
        val client = clientRepository.findOne(id)
        val clientDetails = new ClientDetails().setClient(client)
        model.addAttribute("person", clientDetails)
        "client/model/edit"
    }

    /**
      * Method to edit a model.
      * The URL receives the {id} parameter with the model id.
      **/
    @RequestMapping(path = Array("/model/edit/{id}"), method = Array(RequestMethod.GET))
    def editModel(model: Model, @PathVariable(name = "id") id: Int): String = {
        val clientDetails = clientDetailsRepository.findOne(id)
        model.addAttribute("person", clientDetails)
        "client/model/edit"
    }

    @RequestMapping(path = Array("/model/add"), method = Array(RequestMethod.POST))
    def submitModel(clientDetails: ClientDetails, attributes: RedirectAttributes): String = {
        clientDetailsService.save(clientDetails)
        // TODO: add values for CSS classes in an Enum
        attributes.addFlashAttribute("flashMessage",
            messageSource.getMessage("module.general.saveSuccess.message", null, BaseController.DEFAULT_LOCALE))
        attributes.addFlashAttribute("cssClass", "alert alert-success")
        String.format("redirect:edit/%s", clientDetails.getId.toString)
    }

    @RequestMapping(path = Array("/model/delete/{id}"), method = Array(RequestMethod.GET))
    def deleteModel(model: Model, @PathVariable(name = "id") id: Int): String = {
        val client = clientDetailsRepository.findOne(id).getClient
        //model.addAttribute("client", new Client());
        clientDetailsRepository.delete(id)
        String.format("redirect:../../add/%s", client.getId.toString)
    }

    @RequestMapping(path = Array("/search"), method = Array(RequestMethod.GET))
    def list(model: Model): String = {
        model.addAttribute("client", new ClientDetails)
        model.addAttribute("clients", new util.ArrayList[ClientDetails])
        model.addAttribute("clientType", classOf[ClientType])
        "client/search"
    }

    @RequestMapping(path = Array("/search"), method = Array(RequestMethod.POST))
    def listResults(clientDetails: ClientDetails, clientType: ClientType, bindingResult: BindingResult, model: Model): String = {
        val list = clientDetailsService.findAllByClientType(clientDetails, clientType).asJava

        model.addAttribute("client", clientDetails)
        model.addAttribute("clients", list)
        model.addAttribute("clientType", clientType)
        "client/search"
    }

    @SuppressWarnings(Array("unchecked"))
    @RequestMapping(path = Array("/dashboard"), method = Array(RequestMethod.GET))
    def dashboard(model: Model): String = {
        val now = LocalDate.now
        val currentMonth  = buildOutput(clientDetailsService.findByMonthOfBirth(now.getMonth)).asJava
        val previousMonth = buildOutput(clientDetailsService.findByMonthOfBirth(now.getMonth.minus(1L))).asJava
        val nextMonth     = buildOutput(clientDetailsService.findByMonthOfBirth(now.getMonth.plus(1L))).asJava

        model.addAttribute("currentMonth",  currentMonth)
        model.addAttribute("nextMonth",     nextMonth)
        model.addAttribute("previousMonth", previousMonth)

        "client/dashboard"
    }

    private def buildOutput(clients: List[ClientDetails]): List[ClientDashboardDto] = {
        val clientsDashboardDto = ListBuffer[ClientDashboardDto]()
        clients.foreach(client => {
            val clientDashboard = new ClientDashboardDto(
                client.getName,
                client.getBirthday,
                if (client.getClient == null) ClientType.CLIENT else ClientType.CLIENT
            )
            clientsDashboardDto += clientDashboard
        })
        clientsDashboardDto.sortBy(_.getDayOfMonth).toList
    }

}
