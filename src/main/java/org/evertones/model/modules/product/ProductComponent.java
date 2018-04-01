package org.evertones.model.modules.product;

import org.evertones.model.HasId;
import org.evertones.model.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class ProductComponent implements Model, HasId<ProductComponent, Integer> {

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
    public ProductComponent setId(Integer id) {
        this.id = id;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public ProductComponent setProduct(Product product) {
        this.product = product;
        return this;
    }

    public Product getComponent() {
        return component;
    }

    public ProductComponent setComponent(Product component) {
        this.component = component;
        return this;
    }

    public Double getDiscount() {
        return discount;
    }

    public ProductComponent setDiscount(Double discount) {
        this.discount = discount;
        return this;
    }

    public Short getQuantity() {
        return quantity;
    }

    public ProductComponent setQuantity(Short quantity) {
        this.quantity = quantity;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public ProductComponent setPrice(Double price) {
        this.price = price;
        return this;
    }

    @NotNull
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public ProductComponent setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public ProductComponent setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

}
