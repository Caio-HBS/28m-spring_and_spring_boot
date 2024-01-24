package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {

    Dependency1 dependency1;

    // Field Injection example.
    // @Autowired
    // Dependency1 dependency1;
    // @Autowired
    // Dependency2 dependency2;
    Dependency2 dependency2;
    // Constructor injection.
    @Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructor injection - YourBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    // Setter injection.
//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setting injection for dependency1");
//        this.dependency1 = dependency1;
//    }
//
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setting injection for dependency2");
//        this.dependency2 = dependency2;
//    }

    @Override
    public String toString() {
        return "\nDependency1: " + dependency1 + "\nDependency2: " + dependency2;
    }
}

@Component
class Dependency1 {
}

@Component
class Dependency2 {
}

@Configuration
@ComponentScan
public class DepInjectionAppLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DepInjectionAppLauncher.class)) {
            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
