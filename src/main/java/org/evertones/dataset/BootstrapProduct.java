package org.evertones.dataset;

import org.evertones.dataset.generator.modules.product.ProductGenerator;
import org.evertones.model.modules.product.Product;
import org.evertones.persistence.modules.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BootstrapProduct {

    private ProductRepository productRepository;

    @Autowired
    public void setProdutRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create() {

        ProductGenerator productGenerator = new ProductGenerator();

        Product studioNewBorn    = productGenerator.generate().setName("studio_new_born");
        Product studioPregnant   = productGenerator.generate().setName("studio_pregnant");
        Product studioGeneral    = productGenerator.generate().setName("studio_general");
        Product externalNewBorn  = productGenerator.generate().setName("external_new_born");
        Product externalPregnant = productGenerator.generate().setName("external_pregnant");
        Product externalGeneral  = productGenerator.generate().setName("external_general");

        productRepository.save(studioNewBorn);
        productRepository.save(studioPregnant);
        productRepository.save(studioGeneral);
        productRepository.save(externalNewBorn);
        productRepository.save(externalPregnant);
        productRepository.save(externalGeneral);
    }
}
