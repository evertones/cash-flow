package org.evertones.api;

import org.evertones.controller.dto.MessageDto;
import org.evertones.model.modules.client.ClientDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/test")
public class TestRestController {

    @SuppressWarnings("unchecked")
    @RequestMapping(path = "/ping/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> ping(@PathVariable(name = "id") Integer id) {

        ResponseDto<ClientDetails> response = new ResponseDto<ClientDetails>()
                .setStatus(HttpStatus.OK)
                .setMessage(new MessageDto()
                        .setMessage("This is just a test message.")
                        .setCssClass("alert alert-success"))
                .setEntity(new ClientDetails().setId(id));

        return ResponseEntity.ok(response);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(path = "/ping/list", method = RequestMethod.GET)
    public ResponseEntity<?> list() {

        List<ClientDetails> items = new ArrayList<ClientDetails>();
        items.add(new ClientDetails().setId(1).setName("Australia"));
        items.add(new ClientDetails().setId(2).setName("Brazil"));
        items.add(new ClientDetails().setId(3).setName("Canada"));
        items.add(new ClientDetails().setId(4).setName("Chile"));
        items.add(new ClientDetails().setId(5).setName("England"));
        items.add(new ClientDetails().setId(6).setName("Netherlands"));
        items.add(new ClientDetails().setId(7).setName("Russia"));
        items.add(new ClientDetails().setId(8).setName("United States of America"));

        ResponseDto<ClientDetails> response = new ResponseDto<ClientDetails>()
                .setStatus(HttpStatus.OK)
                .setMessage(new MessageDto()
                        .setMessage("This is just a test message.")
                        .setCssClass("alert alert-success"))
                .setEntities(items);

        return ResponseEntity.ok(response);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(path = "/ping/listRaw", method = RequestMethod.GET)
    public ResponseEntity<SuggestionBoxDto> listRaw(String query) {

        List<SimpleEntityDto> items = new ArrayList<SimpleEntityDto>();
        items.add(new SimpleEntityDto().setId(1).setValue("Australia"));
        items.add(new SimpleEntityDto().setId(2).setValue("Brazil"));
        items.add(new SimpleEntityDto().setId(3).setValue("Canada"));
        items.add(new SimpleEntityDto().setId(4).setValue("Chile"));
        items.add(new SimpleEntityDto().setId(5).setValue("England"));
        items.add(new SimpleEntityDto().setId(6).setValue("Netherlands"));
        items.add(new SimpleEntityDto().setId(7).setValue("Russia"));
        items.add(new SimpleEntityDto().setId(8).setValue("United States of America"));


        SuggestionBoxDto sg = new SuggestionBoxDto<ClientDetails>();
        sg.setQuery("asd");
        sg.setSuggestions(items.stream().filter(
                e -> e.getValue().toLowerCase().contains(query.toLowerCase())).collect(Collectors.toList())
        );

        return ResponseEntity.ok(sg);
    }


}
