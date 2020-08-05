package com.online.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.online.graphql.exceptions.CategoryNotFoundException;
import com.online.graphql.exceptions.InvalidArgumentException;
import com.online.graphql.exceptions.OrderNotFoundException;
import com.online.graphql.exceptions.ProductNotFoundException;

import com.online.graphql.inputs.*;
import com.online.graphql.model.Category;
import com.online.graphql.model.Order;
import com.online.graphql.model.Product;
import com.online.graphql.repositories.CategoryRepository;
import com.online.graphql.repositories.OrdersRepository;
import com.online.graphql.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class Mutator implements GraphQLMutationResolver {

    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;
    private final OrdersRepository ordersRepository;

    /**--------------------------------------------------------------------------*/
    public Product createProduct(CreateProductInput input) {

        Product product = new Product();
        product.setName(input.getName());
        product.setSlug(input.getSlug());
        product.setImage(input.getImage());
        product.setType(input.getType());
        product.setUnit(input.getUnit());
        product.setPrice(input.getPrice());
        product.setSalePrice(input.getSalePrice());
        product.setDisc_in_pros(input.getDisc_in_pros());
        product.setPer_unit(input.getPer_unit());
        product.setQuantity(input.getQuantity());
        product.setDescription(input.getDescription());
        product.setCreation_date(input.getCreation_date());

        return repo.save(product);
    }

    public boolean deleteProduct(Long id) {
        repo.deleteById(id);
        return true;
    }

    public Product updateProductName(UpdateProductNameInput i) {


        Product p = repo.findById(i.getId())
                .orElseThrow(() -> new ProductNotFoundException("product to update not found", i.getId()));

        Optional.ofNullable(i.getName())
                .orElseThrow(() -> new InvalidArgumentException("name cannot be null", i.getName()));

        Optional.ofNullable(i.getSlug())
                .orElseThrow(() -> new InvalidArgumentException("slug cannot be null", i.getSlug()));

        Optional.ofNullable(i.getType())
                .orElseThrow(()-> new InvalidArgumentException("type cannot be null", i.getType()));

        Optional.ofNullable(i.getUnit())
                .orElseThrow(()-> new InvalidArgumentException("unit cannot be null", i.getUnit()));

        Optional.ofNullable(i.getImage())
                .orElseThrow(()-> new InvalidArgumentException("image cannot be null", i.getImage()));

        Optional.ofNullable(i.getDescription())
                .orElseThrow(()-> new InvalidArgumentException("descirption inlcuded small inform", i.getDescription()));


        return repo.save(p);
    }


    public Product updatePrice(UpdateProductPriceInput input){

        Product p = repo.findById(input.getId())
                .orElseThrow(() -> new ProductNotFoundException("product to update not found ", input.getId()));


        return repo.save(p);
    }


    /** -------------------------------Category -------------------------------------------------------- */
    public Category createCategory(CreateCategoryInput input) {

        Category category = new Category();

        category.setName(input.getName());
        category.setIcon(input.getIcon());
        category.setSlug(input.getSlug());
        category.setType(input.getType());
        category.setValue(input.getValue());

        //   product.setCreation_date(input.getCreation_date());

        return categoryRepository.save(category);
    }

    public boolean deleteCategory(Long id) {
        repo.deleteById(id);
        return true;
    }



    public Category updateCategoryName(UpdateCategoryNameInput in) {

        Category p = categoryRepository.findById(in.getId())
                .orElseThrow(() -> new CategoryNotFoundException("category to update not found", in.getId()));

        Optional.ofNullable(in.getName())
                .orElseThrow(() -> new InvalidArgumentException("name cannot be null", in.getName()));

        Optional.ofNullable(in.getIcon())
                .orElseThrow(() -> new InvalidArgumentException("icon should be uploaded", in.getIcon()));

        Optional.ofNullable(in.getSlug())
                .orElseThrow(() -> new InvalidArgumentException("Slug cannot bu null", in.getSlug()));

        Optional.ofNullable(in.getType())
                .orElseThrow(() -> new InvalidArgumentException("type cannot be null.", in.getType()));

        Optional.ofNullable(in.getValue())
                .orElseThrow(()-> new InvalidArgumentException("value cannot be null", in.getValue()));

        return categoryRepository.save(p);
    }


    /**-----------------------------Order-------------------------------------------------------**/

    public Order createOrder(CreateOrderInput input) {

        Order order = new Order();

        order.setAmount(input.getAmount());
        order.setPayment_method(input.getPayment_method());
        order.setContact_number(input.getContact_number());
        order.setDelivery_address(input.getDelivery_address());
        order.setDelivery_fee(input.getDelivery_fee());
        order.setDescription(input.getDescription());
        order.setStatus(input.getStatus());
        order.setDiscount(input.getDiscount());
        //order.setCreation_date(input.getCreation_date);

        return ordersRepository.save(order);
    }

    public boolean deleteOrder(Long id) {
        ordersRepository.deleteById(id);
        return true;
    }

    public Order updateOrderName(UpdateOrderNameInput inp) {


        Order ord = ordersRepository.findById(inp.getId())
                .orElseThrow(() -> new OrderNotFoundException("product to update not found", inp.getId()));


        Optional.ofNullable(inp.getContact_number())
                .orElseThrow(() -> new InvalidArgumentException("contact number cannot be null", inp.getContact_number()));

        Optional.ofNullable(inp.getDelivery_address())
                .orElseThrow(()-> new InvalidArgumentException("Delivery address should be data", inp.getDelivery_address()));

        Optional.ofNullable(inp.getPayment_method())
                .orElseThrow(()-> new InvalidArgumentException("payment method please, selected.", inp.getPayment_method()));

        Optional.ofNullable(inp.getDiscount())
                .orElseThrow(()-> new InvalidArgumentException("Discount should be data", inp.getDiscount()));

        Optional.ofNullable(inp.getStatus())
                .orElseThrow(()-> new InvalidArgumentException("Status should be data", inp.getStatus()));

        Optional.ofNullable(inp.getDescription())
                .orElseThrow(()-> new InvalidArgumentException(" Description should be data", inp.getDescription()));

      return ordersRepository.save(ord);
    }


    public Order updateFee(UpdateOrderFeeInput input){

        Order order = ordersRepository.findById(input.getId())
                .orElseThrow(() -> new OrderNotFoundException("order to update not found ", input.getId()));
        return ordersRepository.save(order);
    }

    /**---------------------------------------------------------------------------**/


}
