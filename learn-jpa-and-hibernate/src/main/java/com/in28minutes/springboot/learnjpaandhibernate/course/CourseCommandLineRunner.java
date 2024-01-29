package com.in28minutes.springboot.learnjpaandhibernate.course;

// import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJDBCRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJDBCRepository repository;

    // @Autowired
    // private CourseJPARepository repository;

    @Autowired
    private CourseSpringDataJPARepository repository;

    @Override
    public void run(String... args) throws Exception {
        // JDBC and JPA way:
        // repository.insert(new Course(1, "Learn Python", "Caio Bianchi"));
        // repository.insert(new Course(2, "Learn Django", "Caio Bianchi"));
        // repository.insert(new Course(3, "Learn React", "Caio Bianchi"));

        // repository.deleteById(1);

        // System.out.println(repository.findById(2));
        // System.out.println(repository.findById(3));

        // Spring Data JPA way:
        repository.save(new Course(1, "Learn Python", "Caio Bianchi"));
        repository.save(new Course(2, "Learn Django", "Caio Bianchi"));
        repository.save(new Course(3, "Learn React", "Caio Bianchi"));

        repository.deleteById(1L);

        System.out.println("\nFind by id: " + "\n2: " + repository.findById(2L));
        System.out.println("3: " + repository.findById(3L));

        System.out.println("\nAll courses: " + "\n" + repository.findAll());
        System.out.println("\nCourses count" + "\n" + repository.count());

        System.out.println("\nFind by name: " + "\n'Caio Bianchi': " + repository.findByAuthor("Caio Bianchi"));
        System.out.println("'': " + repository.findByAuthor(""));

        System.out.println("\nFind by name: " + "\n'Learn React': " + repository.findByName("Learn React"));
        System.out.println("'': " + repository.findByName(""));
    }
}
