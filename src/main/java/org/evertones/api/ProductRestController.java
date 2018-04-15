package org.evertones.api;

import org.evertones.controller.BaseController;
import org.evertones.controller.dto.MessageDto;
import org.evertones.model.modules.client.ClientDetails;
import org.evertones.model.modules.product.Component;
import org.evertones.persistence.modules.product.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/product")
public class ProductRestController extends BaseController {

    private ComponentService componentService;

    @Autowired
    public void setComponentService(ComponentService componentService) {
        this.componentService = componentService;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(path = "/component/delete/{idProduct}/{idComponent}", method = RequestMethod.GET)
    public ResponseEntity<?> delete(Model model, @PathVariable(name = "idProduct") Integer idProduct,
                                    @PathVariable(name = "idComponent") Integer idComponent) {
        componentService.delete(idComponent, idProduct);

        ResponseDto<ClientDetails> response = new ResponseDto<ClientDetails>()
                .setStatus(HttpStatus.OK)
                .setMessage(new MessageDto()
                        .setMessage(messageSource.getMessage("module.general.deleteSuccess.message", null, DEFAULT_LOCALE))
                        .setCssClass("alert alert-success"))
                .setEntity(new Component().setId(idComponent));


        return ResponseEntity.ok(response);
    }

}
