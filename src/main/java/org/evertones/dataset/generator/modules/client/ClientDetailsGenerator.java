package org.evertones.dataset.generator.modules.client;


import org.evertones.dataset.generator.BaseGenerator;
import org.evertones.dataset.generator.common.EmailGenerator;
import org.evertones.dataset.generator.common.PhoneGenerator;
import org.evertones.dataset.generator.util.RandomSex;
import org.evertones.model.modules.client.ClientDetails;
import org.evertones.dataset.generator.util.RandomDate;
import org.evertones.dataset.generator.util.RandomText;

import java.util.Random;

public class ClientDetailsGenerator implements BaseGenerator<ClientDetails> {

    private RandomDate randomDate = new RandomDate();
    private RandomText randomText = new RandomText();
    private RandomSex  randomSex  = new RandomSex();
    private EmailGenerator emailGenerator = new EmailGenerator();
    private PhoneGenerator phoneGenerator = new PhoneGenerator();

    @Override
    public ClientDetails generate() {
        return new ClientDetails()
            //.setId()
            .setName(randomText.randomText("Client"))
            .setBirthday(randomDate.randomLocalDate())
            .setSex(randomSex.randomSex())
            .setEmail(emailGenerator.generate())
            .setPhone(phoneGenerator.generate());
    }
}
