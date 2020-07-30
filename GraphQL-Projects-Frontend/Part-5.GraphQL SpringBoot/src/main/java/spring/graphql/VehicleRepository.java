package spring.graphql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: apple
 * @created on 30/07/2020
 * @Project is GraphQl
 */

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
