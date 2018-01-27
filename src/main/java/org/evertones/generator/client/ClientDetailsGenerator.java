package org.evertones.generator.client;


import org.evertones.generator.BaseGenerator;
import org.evertones.generator.common.EmailGenerator;
import org.evertones.generator.common.PhoneGenerator;
import org.evertones.model.client.ClientDetails;
import org.evertones.util.RandomDate;
import org.evertones.util.RandomText;

public class ClientDetailsGenerator implements BaseGenerator<ClientDetails> {

    private RandomDate randomDate = new RandomDate();
    private RandomText randomText = new RandomText();
    private EmailGenerator emailGenerator = new EmailGenerator();
    private PhoneGenerator phoneGenerator = new PhoneGenerator();

    @Override
    public ClientDetails generate() {
        return new ClientDetails()
            //.setId()
            .setName(randomText.randomText("Client"))
            .setBirthday(randomDate.randomLocalDate())
            .setEmail(emailGenerator.generate())
            .setPhone(phoneGenerator.generate());
    }
}
