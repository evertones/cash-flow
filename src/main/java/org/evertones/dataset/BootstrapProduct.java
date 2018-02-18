package org.evertones.dataset;

import org.evertones.model.service.Product;
import org.evertones.persistence.service.ProductRepository;
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

        Product studioNewBorn    = new Product().setId(1).setName("studio_new_born").setPrice(400D);
        Product studioPregnant   = new Product().setId(2).setName("studio_pregnant").setPrice(300D);
        Product studioGeneral    = new Product().setId(3).setName("studio_general").setPrice(250D);
        Product externalNewBorn  = new Product().setId(4).setName("external_new_born").setPrice(600D);
        Product externalPregnant = new Product().setId(5).setName("external_pregnant").setPrice(500D);
        Product externalGeneral  = new Product().setId(6).setName("external_general").setPrice(450D);

        productRepository.save(studioNewBorn);
        productRepository.save(studioPregnant);
        productRepository.save(studioGeneral);
        productRepository.save(externalNewBorn);
        productRepository.save(externalPregnant);
        productRepository.save(externalGeneral);
    }
}
