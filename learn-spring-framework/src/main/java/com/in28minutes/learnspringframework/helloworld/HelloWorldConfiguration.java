package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
}

record Address(String street, int number) {
}

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Caio";
    }

    @Bean
    public int age() {
        return 24;
    }

    @Bean
    @Primary
    public Person person() {
        return new Person("Eduardo", 24, new Address("Rua das Palmeiras", 49));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Address address() {
        return new Address("Rua dos Anjos", 1004);
    }
}
