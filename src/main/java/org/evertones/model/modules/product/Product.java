package org.evertones.model.modules.product;

import org.evertones.model.HasCreatedAt;
import org.evertones.model.HasId;
import org.evertones.model.HasUpdatedAt;
import org.evertones.model.Model;
import org.evertones.model.types.ProductType;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product implements Model,
        HasId<Product, Integer>,
        HasCreatedAt<Product, LocalDate>,
        HasUpdatedAt<Product, LocalDate> {

    private Integer     id;
    private String      name;
    private Double      price;
    private String      description;
    private Boolean     active = true;
    private LocalDate   createdAt;
    private LocalDate   updatedAt;
    private ProductType productType;

    private List<Component> components = new ArrayList<Component>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public Product setId(Integer id) {
        this.id = id;
        return this;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    @NotNull
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

    @NotNull
    public Boolean getActive() {
        return active;
    }

    public Product setActive(Boolean active) {
        this.active = active;
        return this;
    }

    @NotNull
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

    @NotNull
    public ProductType getProductType() {
        return productType;
    }

    public Product setProductType(ProductType productType) {
        this.productType = productType;
        return this;
    }

    @OneToMany(mappedBy = "product")
    public List<Component> getComponents() {
        return components;
    }

    public Product setComponents(List<Component> components) {
        this.components = components;
        return this;
    }
}
