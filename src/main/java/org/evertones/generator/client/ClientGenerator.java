package org.evertones.generator.client;


import org.evertones.generator.BaseGenerator;
import org.evertones.model.client.Client;
import org.evertones.model.client.ClientDetails;
import org.evertones.util.RandomDate;

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
