package org.evertones.dataset.generator.modules.client;


import org.evertones.dataset.generator.BaseGenerator;
import org.evertones.model.modules.client.Client;
import org.evertones.model.modules.client.ClientDetails;
import org.evertones.dataset.generator.util.RandomDate;

public class ClientGenerator implements BaseGenerator<Client> {

    private ClientDetailsGenerator clientDetailsGenerator = new ClientDetailsGenerator();
    private RandomDate randomDate = new RandomDate();

    @Override
    public Client generate() {
        ClientDetails client = clientDetailsGenerator.generate();
        ClientDetails mother = clientDetailsGenerator.generate();
        ClientDetails father = clientDetailsGenerator.generate();

        return new Client()
//            .setId()
            .setClient(client)
            .setMother(mother)
            .setFather(father)
                .setCreatedAt(randomDate.randomLocalDate())
                .setUpdatedAt(randomDate.randomLocalDate());

    }
}
