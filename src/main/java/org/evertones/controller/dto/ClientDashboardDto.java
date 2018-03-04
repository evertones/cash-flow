package org.evertones.controller.dto;


import org.evertones.model.types.ClientType;

import java.time.LocalDate;

public class ClientDashboardDto {

    public ClientDashboardDto() {
        super();
    }

    public ClientDashboardDto(String name, LocalDate birthday, ClientType type) {
        super();
        this.name = name;
        this.birthday = birthday;
        this.dayOfMonth = birthday.getDayOfMonth();
        this.type = type;
    }

    private String     name;
    private LocalDate  birthday;
    private Integer    dayOfMonth;
    private ClientType type;

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

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }
}
