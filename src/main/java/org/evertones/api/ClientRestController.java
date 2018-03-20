package org.evertones.api;

import org.evertones.controller.BaseController;
import org.evertones.controller.dto.MessageDto;
import org.evertones.model.modules.client.Client;
import org.evertones.model.modules.client.ClientDetails;
import org.evertones.model.types.ClientType;
import org.evertones.persistence.modules.client.ClientDetailsRepository;
import org.evertones.persistence.modules.client.ClientDetailsService;
import org.evertones.persistence.modules.client.ClientRepository;
import org.evertones.persistence.modules.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/client")
public class ClientRestController extends BaseController {

    private ClientDetailsRepository clientDetailsRepository;
    private ClientDetailsService    clientDetailsService;
    private ClientRepository        clientRepository;
    private ClientService           clientService;

    @Autowired
    public void setClientDetailsRepository(ClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Autowired
    public void setClientDetailsService(ClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(path = "/deleteByDetails/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> deteleClientByDetails(@PathVariable(name = "id") Integer id) {

        Boolean success = false;

        // Check if not found

        ClientDetails clientDetails = clientDetailsRepository.findOne(id);
        Client client = clientService.findByClientDetails(clientDetails);
        clientRepository.delete(client);

        ResponseDto<ClientDetails> response = new ResponseDto<ClientDetails>()
                .setStatus(HttpStatus.OK)
                .setMessage(new MessageDto()
                        .setMessage(messageSource.getMessage("module.general.deleteSuccess.message", null, DEFAULT_LOCALE))
                        .setCssClass("alert alert-success"))
                .setEntity(new ClientDetails().setId(id));


        return ResponseEntity.ok(response);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ResponseEntity<SuggestionBoxDto> list(String query) {
        SuggestionBoxDto suggestionBoxDto = new SuggestionBoxDto<ClientDetails>();
        suggestionBoxDto.setQuery("QUERY_CLIENTS");

        List<SimpleEntityDto> items = new ArrayList<SimpleEntityDto>();

        if (query != null && query.length() >= 3) {
            List<ClientDetails> clients = clientDetailsService.findAllByClientType(new ClientDetails().setName(query),
                    ClientType.CLIENT);

            clients.forEach(client ->
                items.add(new SimpleEntityDto(client.getId(), client.getName()))
            );
            suggestionBoxDto.setSuggestions(items);
        }

        return ResponseEntity.ok(suggestionBoxDto);
    }

}
