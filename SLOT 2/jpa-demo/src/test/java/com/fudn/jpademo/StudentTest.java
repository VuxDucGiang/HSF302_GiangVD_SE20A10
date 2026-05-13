package com.fudn.jpademo;

import com.fudn.jpademo.Entity.Student;
import com.fudn.jpademo.Service.StudentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class StudentTest {

    @Autowired
    private StudentService service;

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private StudentService studentService;

    @Test
    void testCreateStudent() {
        Student student = entityManager.find(Student.class, 1L);
        assertNotNull(student);
        assertEquals("Nguyễn Văn A Updated", student.getFullName());
        assertEquals("a.updated@fpt.com", student.getEmail());
        assertEquals(22, student.getAge());

    }

    @Test
    void testCreateAndRetrieveStudentFromDatabase() {
        studentService.createStudent("Test Student", "test@fpt.edu.vn", 25);
        entityManager.flush();
        entityManager.clear();
        Student retrieveStudent = entityManager.find(Student.class, 3L);
        assertNotNull(retrieveStudent, "Student should exist in database");
        assertEquals(3L, retrieveStudent.getId());
        assertEquals("Test Student", retrieveStudent.getFullName());
        assertEquals("test@fpt.edu.vn", retrieveStudent.getEmail());
        assertEquals(25, retrieveStudent.getAge());
    }

    @Test
    void testDeleteStudent() {

        studentService.createStudent(
                "Delete Student",
                "delete@fpt.edu.vn",
                20
        );

        entityManager.flush();
        entityManager.clear();

        Student student = entityManager.find(Student.class, 3L);
        assertNotNull(student);
        studentService.deleteStudent(3L);

        entityManager.flush();
        entityManager.clear();

        Student deletedStudent = entityManager.find(Student.class, 3L);

        assertNull(deletedStudent, "Student should be deleted from database"
        );
    }

}