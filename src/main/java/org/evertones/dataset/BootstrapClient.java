package org.evertones.dataset;

import org.evertones.generator.client.ClientGenerator;
import org.evertones.persistence.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class BootstrapClient {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create() {
        ClientGenerator clientGenerator = new ClientGenerator();

        IntStream.range(1, 10).forEach(item -> {
            clientRepository.save(clientGenerator.generate());
        });
    }
}
