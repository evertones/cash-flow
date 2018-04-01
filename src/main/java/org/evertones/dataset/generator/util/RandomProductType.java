package org.evertones.dataset.generator.util;


import org.evertones.model.types.ProductType;

import java.util.Random;

public class RandomProductType {

    private Random random = new Random();

    public ProductType randomProductType() {
        Integer size = ProductType.values().length;
        Integer randomValue = random.nextInt(size);
        return ProductType.values()[randomValue];
    }

}
