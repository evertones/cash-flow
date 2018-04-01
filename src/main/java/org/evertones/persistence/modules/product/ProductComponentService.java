package org.evertones.persistence.modules.product;

import org.evertones.model.modules.product.Product;
import org.evertones.model.modules.product.ProductComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductComponentService {

    ProductComponentRepository productComponentRepository;

    @Autowired
    public void setProductComponentRepository(ProductComponentRepository productComponentRepository) {
        this.productComponentRepository = productComponentRepository;
    }

    public ProductComponent save(ProductComponent productComponent) {

        if (productComponent.getCreatedAt() == null) {
            productComponent.setCreatedAt(LocalDate.now());
        }
        productComponent.setUpdatedAt(LocalDate.now());

        return productComponentRepository.save(productComponent);
    }

}
