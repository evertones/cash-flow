package org.evertones.model.modules.product;

import org.evertones.model.HasId;
import org.evertones.model.Model;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Component implements Model, HasId<Component, Integer> {

    private Integer   id;
    private Product   product;
    private Product   component;
    private Double    discount;
    private Short     quantity;
    private Double    price;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    @Override
    public Component setId(Integer id) {
        this.id = id;
        return this;
    }

    @OneToOne
    public Product getProduct() {
        return product;
    }

    public Component setProduct(Product product) {
        this.product = product;
        return this;
    }

    @OneToOne
    public Product getComponent() {
        return component;
    }

    public Component setComponent(Product component) {
        this.component = component;
        return this;
    }

    public Double getDiscount() {
        return discount;
    }

    public Component setDiscount(Double discount) {
        this.discount = discount;
        return this;
    }

    public Short getQuantity() {
        return quantity;
    }

    public Component setQuantity(Short quantity) {
        this.quantity = quantity;
        return this;
    }

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    @NotNull
    public Double getPrice() {
        return price;
    }

    public Component setPrice(Double price) {
        this.price = price;
        return this;
    }

    @NotNull
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Component setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public Component setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

}
