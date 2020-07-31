package spring.graph.demo.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.graph.demo.entity.Vehicle;
import spring.graph.demo.service.VehicleService;

/**
 * @Author: apple
 * @created on 31/07/2020
 * @Project is SpringGraphql
 */

@Component
public class VehicleMutation implements GraphQLMutationResolver {

    @Autowired
    private VehicleService vehicleService;

    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate){
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }
}
