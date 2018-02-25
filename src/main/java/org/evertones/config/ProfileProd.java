package org.evertones.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProfileProd {

    public ProfileProd() {
        System.out.println("##########################");
        System.out.println("###        PROD        ###");
        System.out.println("##########################");
    }

}
