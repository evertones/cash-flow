package org.evertones.model.modules.client;

import org.evertones.model.HasId;
import org.evertones.model.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client implements Model,
        HasId<Client, Integer> {

    private Integer       id;
    private ClientDetails client;

    private List<ClientDetails> models = new ArrayList<ClientDetails>();

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

    @OneToMany(mappedBy = "client")
    public List<ClientDetails> getModels() {
        return models;
    }

    public void setModels(List<ClientDetails> models) {
        this.models = models;
    }
}
