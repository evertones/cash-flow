package org.evertones.persistence.modules.client;

import org.evertones.model.modules.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {

        if (client.getCreatedAt() == null) {
            client.setCreatedAt(LocalDate.now());
        }
        client.setUpdatedAt(LocalDate.now());

        if (client.getMother().getName().isEmpty()) {
            client.setMother(null);
        }

        if (client.getFather().getName().isEmpty()) {
            client.setFather(null);
        }

        return clientRepository.save(client);
    }

    public List<Client> findByMonthOfBirth(Month month) {
        return (List<Client>) clientRepository.findAll(ClientSpecification.queryClientBirthday(month));
    }

    public List<Client> findAll(Client client) {
        return (List<Client>) clientRepository.findAll(ClientSpecification.queryAll(client));
    }

}
