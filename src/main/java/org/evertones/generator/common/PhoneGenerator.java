package org.evertones.generator.common;

import org.evertones.generator.BaseGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class PhoneGenerator implements BaseGenerator<String> {

    private Random random = new Random();

    @Override
    public String generate() {
        return String.format("(%s) %s-%s", random.nextInt(100), generatePart(), generatePart());
    }

    private String generatePart() {
        final List<String> parts = new ArrayList<String>();
        IntStream.range(0,4).forEach(i -> {
            parts.add(String.valueOf(random.nextInt(10)));
        });
        return String.join("", parts);
    }
}
