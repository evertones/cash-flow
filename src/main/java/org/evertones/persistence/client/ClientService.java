package org.evertones.persistence.client;

import org.evertones.model.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        if (client.getMother().getName().isEmpty()) {
            client.setMother(null);
        }

        if (client.getFather().getName().isEmpty()) {
            client.setFather(null);
        }

        return clientRepository.save(client);
    }
}
