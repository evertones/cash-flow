package org.evertones.controller.dto;

public class MessageDto {

    private String cssClass;
    private String message;

    public String getCssClass() {
        return cssClass;
    }

    public MessageDto setCssClass(String cssClass) {
        this.cssClass = cssClass;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessageDto setMessage(String message) {
        this.message = message;
        return this;
    }
}
