package org.evertones.model.types;


public enum Sex {

    FEMALE("F"),
    MALE("M"),
    OTHER("O"),
    NOT_INFORMED("NI");

    private String value;
    private String phrase;

    Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getPhrase() {
        switch(this) {
            case FEMALE:       return "module.client.sex.female.label";
            case MALE:         return "module.client.sex.male.label";
            case OTHER:        return "module.client.sex.other.label";
            case NOT_INFORMED: return "module.client.sex.notInformed.label";
            default:
                throw new IllegalArgumentException(String.format("Phrase for {%s} is not supported", this));
        }
    }

    public static Sex findSexByStringValue(String value) {
        switch(value) {
            case "F":  return Sex.FEMALE;
            case "M":  return Sex.MALE;
            case "NI": return Sex.NOT_INFORMED;
            case "O":  return Sex.OTHER;
            default:
                throw new IllegalArgumentException(String.format("Sex value for {%s} is not supported", value));
        }
    }

}
