package org.evertones.generator.cashflow;

import org.evertones.generator.BaseGenerator;
import org.evertones.model.cashflow.Client;
import org.evertones.util.RandomText;

public class ClientGenerator implements BaseGenerator<Client> {

    RandomText randomText = new RandomText();

    @Override
    public Client generate() {
        Client client = new Client();

        //client.setId(RandomText.random.nextInt());
        client.setName(randomText.randomText("Client"));

        return client;
    }
}
