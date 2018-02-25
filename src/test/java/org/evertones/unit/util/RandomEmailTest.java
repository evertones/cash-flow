package org.evertones.unit.util;


import org.evertones.dataset.generator.common.EmailGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class RandomEmailTest {

    private static Logger logger = LoggerFactory.getLogger(RandomEmailTest.class);

    @Test
    public void randomEmail() {
        EmailGenerator emailGenerator = new EmailGenerator();

        IntStream.range(1, 100).forEach(i -> {
            String email = emailGenerator.generate();
            logger.info("Email: " + email);
            Assert.assertTrue("The email contains an @.", email.contains("@"));
            Assert.assertTrue("The email ends with a '.com'.", email.endsWith(".com"));
        });

    }

}
