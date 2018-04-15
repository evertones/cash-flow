package org.evertones.persistence.modules.product;

import org.evertones.model.modules.product.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ComponentService {

    private ComponentRepository componentRepository;

    @Autowired
    public void setComponentRepository(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public Component save(Component component) {

        if (component.getCreatedAt() == null) {
            component.setCreatedAt(LocalDate.now());
        }
        component.setUpdatedAt(LocalDate.now());

        return componentRepository.save(component);
    }

    public Component findOneByComponentProduct(Integer idComponent, Integer idProduct) {
        return componentRepository.findOne(ComponentSpecification.queryComponentProduct(idComponent, idProduct));
    }

    public void delete(Integer idComponent, Integer idProduct) {
        componentRepository.delete(findOneByComponentProduct(idComponent, idProduct));
    }

}
