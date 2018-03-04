package org.evertones.persistence.modules.client;

import org.evertones.model.modules.client.Client;
import org.evertones.model.modules.client.ClientDetails;
import org.evertones.model.modules.client.QClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {

        if (client.getClient().getCreatedAt() == null) {
            client.getClient().setCreatedAt(LocalDate.now());
        }
        client.getClient().setUpdatedAt(LocalDate.now());

        return clientRepository.save(client);
    }

    public Client findByClientDetails(ClientDetails clientDetails) {
        return clientRepository.findOne(QClient.client1.client.eq(clientDetails));
    }

}
