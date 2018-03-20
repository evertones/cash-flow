package org.evertones.api;

public class SimpleEntityDto {

    public SimpleEntityDto() {
        super();
    }

    public SimpleEntityDto(Integer id, String value) {
        super();
        this.id = id;
        this.value = value;
    }

    private Integer id;
    private String value;

    public Integer getId() {
        return id;
    }

    public SimpleEntityDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public SimpleEntityDto setValue(String value) {
        this.value = value;
        return this;
    }
}
