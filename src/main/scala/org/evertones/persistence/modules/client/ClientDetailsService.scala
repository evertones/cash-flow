package org.evertones.persistence.modules.client

import java.time.{LocalDate, Month}

import org.evertones.model.modules.client.ClientDetails
import org.evertones.model.types.ClientType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConverters._

@Service
class ClientDetailsService {

    private var clientDetailsRepository: ClientDetailsRepository = _

    @Autowired
    def setClientDetailsRepository(clientDetailsRepository: ClientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository
    }

    def save(clientDetails: ClientDetails): ClientDetails = {

        if (clientDetails.getCreatedAt == null) clientDetails.setCreatedAt(LocalDate.now())
        clientDetails.setUpdatedAt(LocalDate.now())

        clientDetailsRepository.save(clientDetails)
    }

    def findAllByClientType(clientDetails: ClientDetails, clientType: ClientType): List[ClientDetails] = {
        clientDetailsRepository.findAll(
            ClientDetailsSpecification.queryByClient(clientDetails, clientType)).asScala.toList
    }

    def findByMonthOfBirth(month: Month): List[ClientDetails] = {
        clientDetailsRepository.findAll(
            ClientDetailsSpecification.queryClientDetailsBirthday(month)).asScala.toList
    }

}
