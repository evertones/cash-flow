package org.evertones.model.modules.client;

import org.evertones.model.types.Sex;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class ClientDetails {

    private Integer   id;
    private String    name;
    private Sex       sex;
    private LocalDate birthday;
    private String    phone;
    private String    email;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public ClientDetails setId(Integer id) {
        this.id = id;
        return this;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public ClientDetails setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    public Sex getSex() {
        return sex;
    }

    public ClientDetails setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    public LocalDate getBirthday() {
        return birthday;
    }

    public ClientDetails setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ClientDetails setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientDetails setEmail(String email) {
        this.email = email;
        return this;
    }
}
