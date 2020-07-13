package org.evertones;

import org.evertones.dataset.Bootstrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class CashFlowApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(CashFlowApplication.class);

    private Bootstrap bootstrap;

    private Environment env;

    @Autowired
    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

	public static void main(String[] args) {
		SpringApplication.run(CashFlowApplication.class, args);
	}

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();

        // Locate for Portuguese
        slr.setDefaultLocale(new Locale("pt"));

        // Locale for English - US
        // slr.setDefaultLocale(Locale.US);

        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

	@Override
	public void run(String... strings) throws Exception {
        //String profile = System.getenv("spring.profiles.active");
        String profile = env.getProperty("spring.profiles.active");
        logger.info(String.format("Profile: {%s}", profile));
        if (profile != null && profile.equalsIgnoreCase("dev")) {
            logger.info("Running bootstrap process to start up the fixture data");
            bootstrap.run();
        }
        else {
            logger.info("The bootstrap process WILL NOT be run in production");
        }
	}

}