package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
    public ClassA() {
    }
}

@Component
@Lazy
class ClassB {
    public ClassB() {
        System.out.println("\n---Dummy initialization logic for class B---\n".toUpperCase());
    }

    public void doSomething() {
        System.out.println("CLASS_B_METHOD: \"Doing Something...\"");
    }
}


@Configuration
@ComponentScan
public class LazyInitializationLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncher.class)) {
            System.out.println("SYSTEM: Initialization of context is completed");
            context.getBean(ClassB.class).doSomething();
        }
    }
}
