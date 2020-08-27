package com.market.product.servicemain.web;

import com.market.product.service.api.Product;
import com.market.product.service.api.Products;
import com.market.product.servicemain.domain.ProductRepository;
import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * @Author: apple
 * @created on 26/08/2020
 * @Project is online-management-system
 */

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductRepository productRepository;

    private final DozerBeanMapper mapper = new DozerBeanMapper();

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(com.market.product.servicemain.domain.Product.class, Product.class, TypeMappingOptions.oneWay());
            }
        });
    }

    @RequestMapping
    @ResponseBody
    public Products getProducts(@RequestParam(value = "ids", required = false) String rawIds,
                                @RequestParam(value = "include", required = false) String rawFields) {

        List<com.market.product.servicemain.domain.Product> products = StringUtils.isBlank(rawIds) ?
                productRepository.findAllBy() :
                productRepository.findAllByIdIn(rawIds.split(","));

        Function<com.market.product.servicemain.domain.Product, Product> mapper = StringUtils.isBlank(rawFields) ?
                this::toFullSingletonResource:
                new FieldMapper(rawFields.split(","));
        return new Products(toListResource(products, mapper));
    }

    private Product toFullSingletonResource(com.market.product.servicemain.domain.Product product) {
        return mapper.map(product, Product.class);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable("id") String id ) {
        return toFullSingletonResource(productRepository.findOne(id));
    }

    private List<Product> toListResource(List<com.market.product.servicemain.domain.Product> products, Function<com.market.product.servicemain.domain.Product, Product> mapper) {
        return products.stream().map(mapper).collect(toList());
    }

    private static class FieldMapper implements Function<com.market.product.servicemain.domain.Product, Product> {

        private final String[] fields;

        private FieldMapper(String[] fields) {
            this.fields = fields;
        }

        @Override
        public Product apply(com.market.product.servicemain.domain.Product in) {
           Product out = new Product();

            Arrays.stream(fields).forEach(field -> {
                PropertyDescriptor sourceDescriptor = BeanUtils.getPropertyDescriptor(com.market.product.servicemain.domain.Product.class, field);
                Object value = ReflectionUtils.invokeMethod(sourceDescriptor.getReadMethod(), in);

                PropertyDescriptor destDescriptor = BeanUtils.getPropertyDescriptor(Product.class, field);
                ReflectionUtils.invokeMethod(destDescriptor.getWriteMethod(), out, value);
            });
            return out;
        }
    }
}
