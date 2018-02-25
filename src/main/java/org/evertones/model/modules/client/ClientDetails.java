package org.evertones.model.modules.client;

import org.evertones.model.types.Sex;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Client    client;

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

    @NotNull
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public ClientDetails setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @NotNull
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public ClientDetails setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @OneToOne
    public Client getClient() {
        return client;
    }

    public ClientDetails setClient(Client client) {
        this.client = client;
        return this;
    }
}
