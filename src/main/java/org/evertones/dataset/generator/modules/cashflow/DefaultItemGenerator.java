package org.evertones.dataset.generator.modules.cashflow;

import org.evertones.dataset.generator.BaseGenerator;
import org.evertones.model.modules.cashflow.Item;
import org.evertones.dataset.generator.util.RandomText;

import java.util.Random;

public class DefaultItemGenerator implements BaseGenerator<Item> {

    Random     random     = new Random();
    RandomText randomText = new RandomText();

    @Override
    public Item generate() {
        Item item = new Item();

        //item.setId(RandomText.random.nextInt());
        item.setName(randomText.randomText("Name"));
        item.setValue(random.nextDouble());
        item.setActive(random.nextBoolean());

        return item;
    }

}