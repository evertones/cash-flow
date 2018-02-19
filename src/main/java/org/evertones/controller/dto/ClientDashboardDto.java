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
        this.dayOfMonth = birthday.getDayOfMonth();
        this.type = type;
    }

    private String    name;
    private LocalDate birthday;
    private Integer   dayOfMonth;
    private String    type; //client, mother, father

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

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
