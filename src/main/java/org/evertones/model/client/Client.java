package org.evertones.model.client;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Client {

    private Integer       id;
    private ClientDetails client;
    private ClientDetails father;
    private ClientDetails mother;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    public ClientDetails getClient() {
        return client;
    }

    public void setClient(ClientDetails client) {
        this.client = client;
    }

    @OneToOne
    public ClientDetails getFather() {
        return father;
    }

    public void setFather(ClientDetails father) {
        this.father = father;
    }

    @OneToOne
    public ClientDetails getMother() {
        return mother;
    }

    public void setMother(ClientDetails mother) {
        this.mother = mother;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
