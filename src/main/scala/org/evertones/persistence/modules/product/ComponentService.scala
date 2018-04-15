package org.evertones.persistence.modules.product

import java.time.LocalDate

import org.evertones.model.modules.product.Component
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ComponentService {

    private[product] var componentRepository: ComponentRepository = null

    @Autowired
    def setComponentRepository(componentRepository: ComponentRepository): Unit = {
        this.componentRepository = componentRepository
    }

    def save(component: Component): Component = {
        if (component.getCreatedAt == null) component.setCreatedAt(LocalDate.now)

        component.setUpdatedAt(LocalDate.now)
        componentRepository.save(component)
    }

}
