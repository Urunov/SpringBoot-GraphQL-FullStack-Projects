package spring.graph.demo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.graph.demo.entity.Vehicle;
import spring.graph.demo.service.VehicleService;

import java.util.List;
import java.util.Optional;

/**
 * @Author: apple
 * @created on 31/07/2020
 * @Project is SpringGraphql
 */

@Component
public class VehileQuery implements GraphQLQueryResolver {

    @Autowired
    private VehicleService vehicleService;

    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicle(count);
    }

    public Optional<Vehicle> getVehicle(final int id){
        return this.vehicleService.getVehicle(id);
    }
}
