package com.kattensvaern.controller;

import com.kattensvaern.service.TestService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://127.0.0.1:5500"})
public class TestController {

    private final TestService test;

    public TestController(TestService test){
        this.test = test;
    }

    @GetMapping("/api/hello")
    public String helloBackend(){
        return test.sayHello();
    }

}
