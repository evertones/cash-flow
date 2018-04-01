package org.evertones.dataset;

import org.evertones.dataset.generator.modules.product.ProductGenerator;
import org.evertones.persistence.modules.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class BootstrapProduct {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create() {
        ProductGenerator productGenerator = new ProductGenerator();

        IntStream.range(1, 100).forEach(item -> {
            productRepository.save(productGenerator.generate());
        });
    }
}
