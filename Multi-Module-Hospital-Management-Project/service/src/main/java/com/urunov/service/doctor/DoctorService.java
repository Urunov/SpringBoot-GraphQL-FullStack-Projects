package com.urunov.service.doctor;

import com.urunov.mailservice.EmailService;
import com.urunov.model.doctor.Doctor;
import coml.urunov.dao.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;


/**
 * @Author: apple
 * @created on 25/08/2020
 * @Project is hospital-management-system
 */
@Service

public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private EmailService service;

    @PostConstruct
    public void initDoctor(){
        repository.saveAll(Stream.of
                (new Doctor(101,"John","Cardiac"),
                        new Doctor(102,"peter","eye"))
                .collect(Collectors.toList()));
    }

    public List<Doctor> getDoctors(){
        service.sendMail();
        return repository.findAll();
    }
}
