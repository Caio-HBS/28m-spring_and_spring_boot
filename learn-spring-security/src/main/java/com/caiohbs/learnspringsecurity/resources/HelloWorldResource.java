package com.caiohbs.learnspringsecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @GetMapping(path="/hello-world")
    public String HelloWorld() {
        return "Hello World";
    }

}
