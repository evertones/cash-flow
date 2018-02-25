package org.evertones.dataset.generator.util;


import org.evertones.model.types.Sex;

import java.util.Random;

public class RandomSex {

    private Random random = new Random();

    public Sex randomSex() {
        Integer size = Sex.values().length;
        Integer randomValue = random.nextInt(size);
        return Sex.values()[randomValue];
    }

}
