package org.evertones.dataset.generator.modules.client;


import org.evertones.dataset.generator.BaseGenerator;
import org.evertones.model.modules.client.Client;
import org.evertones.model.modules.client.ClientDetails;

public class ClientGenerator implements BaseGenerator<Client> {

    private ClientDetailsGenerator clientDetailsGenerator = new ClientDetailsGenerator();

    @Override
    public Client generate() {
        ClientDetails client = clientDetailsGenerator.generate();

        return new Client()
//            .setId()
            .setClient(client);

    }
}
