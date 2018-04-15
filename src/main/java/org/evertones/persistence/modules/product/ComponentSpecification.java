package org.evertones.persistence.modules.product;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.evertones.model.modules.product.QComponent;

public class ComponentSpecification {

    static BooleanExpression queryComponentProduct(Integer idComponent, Integer idProduct) {
        return QComponent.component1.id.eq(idComponent).and(QComponent.component1.product.id.eq(idProduct));
    }

}
