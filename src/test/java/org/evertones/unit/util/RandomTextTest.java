package org.evertones.unit.util;


import org.evertones.util.RandomText;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class RandomTextTest {

    private RandomText randomString = new RandomText();

    @Test
    public void randomTextWithParamName() {
        IntStream.range(1, 100).forEach(i -> {
            String name = randomString.randomText();
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
