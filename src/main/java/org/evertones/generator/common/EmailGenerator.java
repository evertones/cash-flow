package org.evertones.generator.common;

import org.evertones.generator.BaseGenerator;
import org.evertones.util.RandomText;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmailGenerator implements BaseGenerator<String> {

    static final List<String> NAMES = Arrays.asList("arnold", "silvester", "jimmy", "eddie", "chris", "denzel",
            "rob", "tom", "leonardo", "brad", "russel", "tom");

    static final List<String> DOMAINS = Arrays.asList("gmail.com", "outlook.com", "hotmail.com", "yahoo.com",
            "aol.com", "company.com");

    Random     random     = new Random();
    RandomText randomText = new RandomText();

    @Override
    public String generate() {
        String name = NAMES.get(random.nextInt(NAMES.size()));
        String surName = randomText.randomText();
        String domain = DOMAINS.get(random.nextInt(DOMAINS.size()));

        return String.format("%s_%s@%s", name, surName, domain);
    }
}
