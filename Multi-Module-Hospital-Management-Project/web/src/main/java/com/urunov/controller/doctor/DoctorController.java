package com.urunov.controller.doctor;

import com.urunov.model.doctor.Doctor;
import com.urunov.service.doctor.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: apple
 * @created on 25/08/2020
 * @Project is hospital-management-system
 */
@RestController
public class DoctorController {

    private DoctorService service;

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return service.getDoctors();
    }
}
