package org.evertones.unit.security;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PasswordTest {

    private static Logger logger = LoggerFactory.getLogger(PasswordTest.class);

    @Test
    public void password() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Set<String> passwords = new HashSet<String>();

        IntStream.range(1, 10).forEach(i -> {
            String encodedPassword = passwordEncoder.encode("password");
            logger.info("Password: " + encodedPassword);

            org.junit.Assert.assertTrue("Password is always different", passwords.add(encodedPassword));
        });

        logger.info("Passwords generated: " + passwords.size());
    }

    @Test
    public void generatePassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(""));
    }

}
