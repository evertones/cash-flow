package org.evertones.generator.cashflow;

import org.evertones.generator.BaseGenerator;
import org.evertones.model.cashflow.Item;
import org.evertones.util.RandomText;

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