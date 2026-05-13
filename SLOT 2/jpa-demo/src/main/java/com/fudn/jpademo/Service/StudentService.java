package com.fudn.jpademo.Service;

import com.fudn.jpademo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createStudent(String name, String email, int age) {

        Student s = new Student(name, email, age);

        em.persist(s); // INSERT

        System.out.println("Saved with ID = " + s.getId());
    }

    @Transactional(readOnly = true)
    public void printAll() {

        em.createQuery(
                        "SELECT s FROM Student s",
                        Student.class
                )
                .getResultList()
                .forEach(System.out::println);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email, int age) {
        Student student = em.find(Student.class, id);

        if (student != null) {
            student.setFullName(name);
            student.setEmail(email);
            student.setAge(age);
            em.merge(student);
            System.out.println("Student updated!");
        } else {
            System.out.println("Student not found");
        }

    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
            System.out.println("Student deleted!");
        } else {
            System.out.println("Student not found!");
        }
    }
}