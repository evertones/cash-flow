package org.evertones.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class ProfileDev {

    public ProfileDev() {
        System.out.println("##########################");
        System.out.println("###         DEV        ###");
        System.out.println("##########################");
    }

}
