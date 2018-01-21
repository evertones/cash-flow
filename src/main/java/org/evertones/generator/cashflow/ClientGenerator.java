package org.evertones.generator.cashflow;

import org.evertones.generator.BaseGenerator;
import org.evertones.model.cashflow.Client;
import org.evertones.util.Random;

public class ClientGenerator implements BaseGenerator<Client> {

    @Override
    public Client generate() {
        Client client = new Client();

        //client.setId(Random.random.nextInt());
        client.setName(Random.randomText("Client"));

        return client;
    }
}
