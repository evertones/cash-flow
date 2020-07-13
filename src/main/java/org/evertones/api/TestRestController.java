package org.evertones.api;

import org.evertones.controller.dto.MessageDto;
import org.evertones.model.modules.client.ClientDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/test")
public class TestRestController {

    @SuppressWarnings("unchecked")
    @Secured("ROLE_ADMIN")
    @RequestMapping(path = "/ping/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deteleClientByDetails(@PathVariable(name = "id") Integer id) {

        ResponseDto<ClientDetails> response = new ResponseDto<ClientDetails>()
                .setStatus(HttpStatus.OK)
                .setMessage(new MessageDto()
                        .setMessage("This is just a test message.")
                        .setCssClass("alert alert-success"))
                .setEntity(new ClientDetails().setId(id));

        return ResponseEntity.ok(response);
    }


}
