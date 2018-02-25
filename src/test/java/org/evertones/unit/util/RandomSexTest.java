package org.evertones.unit.util;


import org.evertones.dataset.generator.util.RandomSex;
import org.evertones.model.types.Sex;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class RandomSexTest {

    private RandomSex randomSex = new RandomSex();

    @Test
    public void randomSex() {
        IntStream.range(1, 100).forEach(i -> {
            Sex sex = randomSex.randomSex();

            System.out.println("Sex value: " + sex.getValue());
            System.out.println("Sex value: " + sex.getPhrase());
            //Assert.assertTrue("The text contains the desired string.", text.contains(name));
        });
    }

}
