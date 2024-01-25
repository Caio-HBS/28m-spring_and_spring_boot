package com.in28minutes.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private final SomeDependency someDep;

    public SomeClass(SomeDependency someDep) {
        super();
        this.someDep = someDep;
        System.out.println("Dependencies are wired in!");
    }

    @PostConstruct
    public void initialize() {
        someDep.getReady();
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("\n---CLOSING DB CONNECTION---");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("\n---GETTING DATA FROM DB---\n");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationsLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsLauncher.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
