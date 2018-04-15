package org.evertones.persistence.modules.product

import java.time.LocalDate
import java.util

import org.evertones.model.modules.product.{Product, QProduct}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ProductService {

    private[product] var productRepository: ProductRepository = _

    @Autowired
    def setProductRepository(productRepository: ProductRepository): Unit = {
        this.productRepository = productRepository
    }

    def save(product: Product): Product = {
        if (product.getCreatedAt == null) product.setCreatedAt(LocalDate.now)

        product.setUpdatedAt(LocalDate.now)
        productRepository.save(product)
    }

    def findAllNotProduct: util.List[Product] = {
        productRepository.findAll(
            ProductSpecification.queryProductTypeNotProduct,
            new Sort(Sort.Direction.ASC, QProduct.product.name.getMetadata.getName)).asInstanceOf[util.List[Product]]
    }

}
