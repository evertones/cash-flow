package org.evertones.controller.dto;


import java.time.LocalDate;

public class ClientDashboardDto {

    public ClientDashboardDto() {
        super();
    }

    public ClientDashboardDto(String name, LocalDate birthday, String type) {
        super();
        this.name = name;
        this.birthday = birthday;
        this.month = birthday.getMonthValue();
        this.type = type;
    }

    private String name;
    private LocalDate birthday;
    private Integer month;
    private String type; //client, mother, father

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
