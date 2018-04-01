package org.evertones.dataset.generator.modules.product;

import org.evertones.dataset.generator.BaseGenerator;
import org.evertones.dataset.generator.util.RandomDate;
import org.evertones.dataset.generator.util.RandomProductType;
import org.evertones.dataset.generator.util.RandomText;
import org.evertones.model.modules.product.Product;

import java.util.Random;

public class ProductGenerator implements BaseGenerator<Product> {

    private RandomDate        randomDate        = new RandomDate();
    private RandomText        randomText        = new RandomText();
    private RandomProductType randomProductType = new RandomProductType();

    @Override
    public Product generate() {
        return new Product()
            // .setId()
            .setName(randomText.randomText("Product Type - Name"))
            .setDescription(randomText.randomText("Product Type - Description"))
            .setActive(true)
            .setCreatedAt(randomDate.randomLocalDate())
            .setPrice(new Random().nextDouble())
            .setProductType(randomProductType.randomProductType());
    }

    private Double randomPrice() {
        Random random = new Random();
        return random.nextDouble() * random.nextInt(100);
    }
}
