package org.evertones.unit.util;


import org.evertones.util.RandomString;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class RandomStringTest {

    RandomString randomString = new RandomString();

    @Test
    public void randomTextWithParamName() {
        IntStream.range(1, 100).forEach(i -> {
            String name = randomString.randomText(10);
            String text = randomString.randomText(name);
            Assert.assertTrue("The text contains the desired string.", text.contains(name));
        });
    }

    @Test
    public void randomTextWithParamSize() {
        IntStream.range(1, 100).forEach(i -> {
            String text = randomString.randomText(i);
            Assert.assertTrue("The size of text is correct.", text.length() == i);
        });
    }

}
