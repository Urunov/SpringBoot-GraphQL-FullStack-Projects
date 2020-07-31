package spring.graph.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.graph.demo.entity.Vehicle;

/**
 * @Author: apple
 * @created on 31/07/2020
 * @Project is SpringGraphql
 */
@Repository
public interface VehicleRepository  extends JpaRepository<Vehicle, Integer> {
}
