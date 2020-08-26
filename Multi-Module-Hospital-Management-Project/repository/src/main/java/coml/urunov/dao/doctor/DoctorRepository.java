package coml.urunov.dao.doctor;

import com.urunov.model.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 25/08/2020
 * @Project is hospital-management-system
 */
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
