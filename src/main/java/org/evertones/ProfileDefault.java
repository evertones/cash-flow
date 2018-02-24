package org.evertones;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class ProfileDefault {

    public ProfileDefault() {
        System.out.println("##########################");
        System.out.println("###       DEFAULT      ###");
        System.out.println("##########################");
    }

}
