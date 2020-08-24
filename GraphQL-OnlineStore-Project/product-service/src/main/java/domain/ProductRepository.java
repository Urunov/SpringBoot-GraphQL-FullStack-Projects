package domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findAllBy();

    List<Product> findAllByIdIn(String[] ids);
}
