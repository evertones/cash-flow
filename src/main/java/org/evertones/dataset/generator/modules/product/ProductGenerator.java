package org.evertones.dataset.generator.modules.product;

import org.evertones.dataset.generator.BaseGenerator;
import org.evertones.dataset.generator.util.RandomDate;
import org.evertones.dataset.generator.util.RandomText;
import org.evertones.model.modules.product.Product;

import java.util.Random;

public class ProductGenerator implements BaseGenerator<Product> {

    private Random     random     = new Random();
    private RandomDate randomDate = new RandomDate();
    private RandomText randomText = new RandomText();

    @Override
    public Product generate() {
        return new Product()
                //.setId()
                .setName(randomText.randomText())
                .setPrice(random.nextDouble() * random.nextInt(1000))
                .setCreatedAt(randomDate.randomLocalDate())
                .setUpdatedAt(randomDate.randomLocalDate())
                .setActive(random.nextBoolean())
                .setDescription(randomText.randomText());
    }
}
