package com.caiohbs.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Caio Bianchi");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("Caio", "Bianchi"));
    }

    @GetMapping(path="/person", params="version=1")
    public PersonV1 getPersonRequestParamFirstVersion() {
        return new PersonV1("Caio Bianchi");
    }

    @GetMapping(path="/person", params="version=2")
    public PersonV2 getPersonRequestParamSecondVersion() {
        return new PersonV2(new Name("Caio", "Bianchi"));
    }

    @GetMapping(path="/person/header", headers="X-API-VERSION=1")
    public PersonV1 getPersonHeaderFirstVersion() {
        return new PersonV1("Caio Bianchi");
    }

    @GetMapping(path="/person/header", headers="X-API-VERSION=2")
    public PersonV2 getPersonHeaderSecondVersion() {
        return new PersonV2(new Name("Caio", "Bianchi"));
    }

    @GetMapping(path="/person/accept-header", produces="application/vnd.company.app-v1+json")
    public PersonV1 getPersonAcceptHeaderFirstVersion() {
        return new PersonV1("Caio Bianchi");
    }

    @GetMapping(path="/person/accept-header", produces="application/vnd.company.app-v2+json")
    public PersonV2 getPersonAcceptHeaderSecondVersion() {
        return new PersonV2(new Name("Caio", "Bianchi"));
    }
}
