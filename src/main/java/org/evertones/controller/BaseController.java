package org.evertones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class BaseController {

    protected static final Locale DEFAULT_LOCALE = new Locale("pt");

    protected MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

}
