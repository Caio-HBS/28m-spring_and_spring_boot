package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJPARepository {
    @PersistenceContext
    private EntityManager manager;

    public void insert(Course course) {
        manager.merge(course);
    }

    public void deleteById(long id) {
        Course foundCourse = manager.find(Course.class, id);

        manager.remove(foundCourse);
    }

    public Course findById(long id) {
        return manager.find(Course.class, id);
    }
}
