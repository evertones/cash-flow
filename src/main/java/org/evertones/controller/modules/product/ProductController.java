package org.evertones.controller.modules.product;

import org.evertones.model.modules.product.Product;
import org.evertones.persistence.modules.product.ProductRepository;
import org.evertones.persistence.modules.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    private ProductRepository productRepository;
    private ProductService    productService;
    private MessageSource     messageSource;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product/list";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("product", new Product());

        return "product/edit";
    }

    @RequestMapping(path = "/add/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(name = "id") Integer id) {
        model.addAttribute("product", productRepository.findOne(id));
        return "product/edit";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String submit(Product product, RedirectAttributes attributes) {
        productService.save(product);

        // TODO: 1) Get the default locale; 2) add values for CSS classes in an Enum
        Locale defaultLocale = new Locale("pt");
        attributes.addFlashAttribute("flashMessage", messageSource.getMessage("module.general.saveSuccess.message", null, defaultLocale));
        attributes.addFlashAttribute("cssClass", "alert alert-success");

        return String.format("redirect:add/%s", product.getId().toString());
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(name = "id") Integer id) {
        productRepository.delete(id);
        return "redirect:../list";
    }

}
