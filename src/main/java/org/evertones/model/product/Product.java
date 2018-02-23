package org.evertones.model.product;

import org.evertones.model.HasCreatedAt;
import org.evertones.model.HasId;
import org.evertones.model.HasUpdatedAt;
import org.evertones.model.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Product implements Model,
        HasId<Product, Integer>,
        HasCreatedAt<Product, LocalDate>,
        HasUpdatedAt<Product, LocalDate>{

    private Integer   id;
    private String    name;
    private Double    price;
    private String    description;
    private Boolean   active = true;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public Product setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean isActive() {
        return active;
    }

    public Product setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Product setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public Product setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

}
