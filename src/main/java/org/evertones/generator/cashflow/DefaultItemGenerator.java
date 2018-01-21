package org.evertones.generator.cashflow;

import org.evertones.generator.BaseGenerator;
import org.evertones.model.cashflow.Item;
import org.evertones.util.Random;

public class DefaultItemGenerator implements BaseGenerator<Item> {

    @Override
    public Item generate() {
        Item item = new Item();

        //item.setId(Random.random.nextInt());
        item.setName(Random.randomText("Name"));
        item.setValue(Random.randomValue());
        item.setActive(Random.random.nextBoolean());

        return item;
    }

}