package org.evertones.generator.cashflow;

import org.evertones.generator.BaseGenerator;
import org.evertones.model.cashflow.ClientOld;
import org.evertones.util.RandomText;

public class ClientGenerator implements BaseGenerator<ClientOld> {

    RandomText randomText = new RandomText();

    @Override
    public ClientOld generate() {
        ClientOld clientOld = new ClientOld();

        //clientOld.setId(RandomText.random.nextInt());
        clientOld.setName(randomText.randomText("ClientOld"));

        return clientOld;
    }
}
