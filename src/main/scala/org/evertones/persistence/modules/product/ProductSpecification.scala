package org.evertones.persistence.modules.product

import org.evertones.model.modules.product.QProduct
import org.evertones.model.types.ProductType

object ProductSpecification {

    private[product] def queryProductTypeNotProduct = QProduct.product.productType.ne(ProductType.PRODUCT)

}
