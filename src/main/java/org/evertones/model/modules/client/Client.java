package org.evertones.model.modules.client;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Client {

    private Integer       id;
    private ClientDetails client;
    private ClientDetails father;
    private ClientDetails mother;
    private LocalDate     createdAt;
    private LocalDate     updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public Client setId(Integer id) {
        this.id = id;
        return this;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    public ClientDetails getClient() {
        return client;
    }

    public Client setClient(ClientDetails client) {
        this.client = client;
        return this;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    public ClientDetails getFather() {
        return father;
    }

    public Client setFather(ClientDetails father) {
        this.father = father;
        return this;
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    public ClientDetails getMother() {
        return mother;
    }

    public Client setMother(ClientDetails mother) {
        this.mother = mother;
        return this;
    }

    @NotNull
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Client setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @NotNull
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public Client setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

}
