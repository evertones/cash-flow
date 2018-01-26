package org.evertones.generator.cashflow;

import org.evertones.generator.BaseGenerator;
import org.evertones.model.cashflow.Client;
import org.evertones.util.RandomString;

public class ClientGenerator implements BaseGenerator<Client> {

    RandomString randomString = new RandomString();

    @Override
    public Client generate() {
        Client client = new Client();

        //client.setId(RandomString.random.nextInt());
        client.setName(randomString.randomText("Client"));

        return client;
    }
}
