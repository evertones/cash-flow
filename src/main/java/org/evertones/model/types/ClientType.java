package org.evertones.model.types;

public enum ClientType {

    CLIENT(0),
    MODEL(1);

    ClientType(Integer value) {
        this.value = value;
    }

    private Integer value;
    private String phrase;

    public Integer getValue() {
        return this.value;
    }

    public String getPhrase() {
        switch(this) {
            case CLIENT: return "module.client.type.client.label";
            case MODEL:  return "module.client.type.model.label";
            default:
                throw new IllegalArgumentException(String.format("Phrase for {%s} is not supported", this));
        }
    }

}
