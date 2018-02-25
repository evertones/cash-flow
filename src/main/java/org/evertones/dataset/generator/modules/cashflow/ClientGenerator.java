package org.evertones.dataset.generator.modules.cashflow;

import org.evertones.dataset.generator.BaseGenerator;
import org.evertones.dataset.generator.util.RandomText;
import org.evertones.model.modules.cashflow.ClientOld;

public class ClientGenerator implements BaseGenerator<ClientOld> {

    RandomText randomText = new RandomText();

    @Override
    public ClientOld generate() {
        ClientOld clientOld = new ClientOld();

        clientOld.setName(randomText.randomText("ClientOld"));

        return clientOld;
    }
}
