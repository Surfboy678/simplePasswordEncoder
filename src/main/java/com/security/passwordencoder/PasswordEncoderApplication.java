package com.security.passwordencoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PasswordEncoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasswordEncoderApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void test(){
        MyPasswordEncoder myPasswordEncoder = new MyPasswordEncoder();
        System.out.println(myPasswordEncoder.encode("Anna"));
        System.out.println(myPasswordEncoder.matches("Janusz", myPasswordEncoder.encode("Janusz")));
    }


}


