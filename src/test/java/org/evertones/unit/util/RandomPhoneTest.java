package org.evertones.unit.util;


import org.evertones.generator.common.EmailGenerator;
import org.evertones.generator.common.PhoneGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class RandomPhoneTest {

    private static Logger logger = LoggerFactory.getLogger(RandomPhoneTest.class);

    @Test
    public void randomPhone() {
        PhoneGenerator phoneGenerator = new PhoneGenerator();

        IntStream.range(1, 100).forEach(i -> {
            String phone = phoneGenerator.generate();
            logger.info("Phone: " + phone);
            Assert.assertTrue("The phone contains an -.", phone.contains("-"));
            Assert.assertTrue("The phone contains an -.", phone.contains("("));
            Assert.assertTrue("The phone contains an -.", phone.contains(")"));
            Assert.assertTrue("The phone must have length between 13 and 14.", phone.length() >= 13 && phone.length()<= 14);
        });

    }

}
