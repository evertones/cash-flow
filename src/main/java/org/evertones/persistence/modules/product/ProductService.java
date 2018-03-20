package org.evertones.persistence.modules.product;

import org.evertones.model.modules.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {

        if (product.getCreatedAt() == null) {
            product.setCreatedAt(LocalDate.now());
        }
        product.setUpdatedAt(LocalDate.now());

        return productRepository.save(product);
    }

    public List<Product> findAllBy(String name) {
        return (List<Product>) productRepository.findAll(ProductSpecification.queryProductByName(name));
    }

}
