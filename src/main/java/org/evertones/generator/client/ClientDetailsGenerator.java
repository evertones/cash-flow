package org.evertones.generator.client;


import org.evertones.generator.BaseGenerator;
import org.evertones.model.client.ClientDetails;
import org.evertones.util.RandomDate;
import org.evertones.util.RandomString;

public class ClientDetailsGenerator implements BaseGenerator<ClientDetails> {

    RandomDate   randomDate   = new RandomDate();
    RandomString randomString = new RandomString();

    @Override
    public ClientDetails generate() {
        return new ClientDetails()
            //.setId()
            .setName(randomString.randomText("Client"))
            .setBirthday(randomDate.randomLocalDate());
//            .setEmail(RandomString.random.)
//            .setPhone();

//        RandomString.random.

    }
}
