package com.in28minutes.springboot.learnjpaandhibernate.course;

// import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJDBCRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    //@Autowired
    // private CourseJDBCRepository repository;

    @Autowired
    private CourseJPARepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn Python", "Caio Bianchi"));
        repository.insert(new Course(2, "Learn Django", "Caio Bianchi"));
        repository.insert(new Course(3, "Learn React", "Caio Bianchi"));

        repository.deleteById(1);

        System.out.println(repository.findById(2));
        System.out.println(repository.findById(3));
    }
}
