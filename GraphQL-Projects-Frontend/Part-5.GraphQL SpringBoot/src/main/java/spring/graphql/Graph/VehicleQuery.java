package spring.graphql.Graph;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.graphql.Vehicle;

import java.util.List;
import java.util.Optional;

/**
 * @Author: apple
 * @created on 30/07/2020
 * @Project is GraphQl
 */

@Component
public class VehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private VehicleService vehicleService;

    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }

    public Optional<Vehicle> getAllVehicles(final int id){
        return this.vehicleService.getVehicle(id);
    }
}
