package web;

import domain.Product;
import domain.ProductRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.yaml.snakeyaml.nodes.NodeId.mapping;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductRepository productRepository;

    private final DozerBeanMapper mapper = new DozerBeanMapper();

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;

        mapper.addMaping(BeanMapinngBuilder () -> {
            mapping(Product.class, Product.class, TypeMappingOptions.oneWay());
        });
    }


    @RequestMapping
    @ResponseBody
    public Products getProducts(){

    }
}
