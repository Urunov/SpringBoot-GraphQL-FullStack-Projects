package spring.graphql.Graph;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.graphql.Vehicle;

/**
 * @Author: apple
 * @created on 30/07/2020
 * @Project is GraphQl
 */
@Component
public class VehicleMutation implements GraphQLMutationResolver {


    @Autowired
    private VehicleService vehicleService;

    public Vehicle createVehicle(final String type, final String modelCode, String brandName, final String launchDate) {

        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }

}
