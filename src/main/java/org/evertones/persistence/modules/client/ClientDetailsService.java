package org.evertones.persistence.modules.client;

import org.evertones.model.modules.client.ClientDetails;
import org.evertones.model.types.ClientType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ClientDetailsService {

    private ClientDetailsRepository clientDetailsRepository;

    @Autowired
    public void setClientDetailsRepository(ClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    public ClientDetails save(ClientDetails clientDetails) {

        if (clientDetails.getCreatedAt() == null) {
            clientDetails.setCreatedAt(LocalDate.now());
        }
        clientDetails.setUpdatedAt(LocalDate.now());

        return clientDetailsRepository.save(clientDetails);
    }

    public List<ClientDetails> findAllByClientType(ClientDetails clientDetails, ClientType clientType) {
        return (List<ClientDetails>) clientDetailsRepository
                .findAll(ClientDetailsSpecification.queryByClient(clientDetails, clientType));
    }

    public List<ClientDetails> findByMonthOfBirth(Month month) {
        return (List<ClientDetails>) clientDetailsRepository.findAll(
                ClientDetailsSpecification.queryClientDetailsBirthday(month)
        );
    }

}
