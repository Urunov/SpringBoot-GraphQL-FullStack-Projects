package com.urunov.mailservice;

/**
 * @Author: apple
 * @created on 25/08/2020
 * @Project is hospital-management-system
 */
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendMail(){
        System.out.println("Email service is working!");
    }
}
