package org.evertones.persistence.modules.client

import java.time.LocalDate

import org.evertones.model.modules.client.{Client, ClientDetails, QClient}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientService {

    private var clientRepository: ClientRepository = _

    @Autowired
    def setClientRepository(clientRepository: ClientRepository): Unit = {
        this.clientRepository = clientRepository
    }

    def save(client: Client): Client = {

        if (client.getClient.getCreatedAt == null) {
            client.getClient.setCreatedAt(LocalDate.now())
        }
        client.getClient.setUpdatedAt(LocalDate.now())

        clientRepository.save(client)
    }

    def findByClientDetails(clientDetails: ClientDetails): Client = {
        clientRepository.findOne(QClient.client1.client.eq(clientDetails))
    }

}
