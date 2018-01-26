package org.evertones.generator.cashflow;

import org.evertones.generator.BaseGenerator;
import org.evertones.model.cashflow.Item;
import org.evertones.util.RandomString;

import java.util.Random;

public class DefaultItemGenerator implements BaseGenerator<Item> {

    Random       random       = new Random();
    RandomString randomString = new RandomString();

    @Override
    public Item generate() {
        Item item = new Item();

        //item.setId(RandomString.random.nextInt());
        item.setName(randomString.randomText("Name"));
        item.setValue(random.nextDouble());
        item.setActive(random.nextBoolean());

        return item;
    }

}