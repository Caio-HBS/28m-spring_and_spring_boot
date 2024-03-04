package com.caiohbs.restful.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthResource {

    @GetMapping(path="/basic-auth")
    public String basicAuthCheck() {
        return "Success";
    }

}
