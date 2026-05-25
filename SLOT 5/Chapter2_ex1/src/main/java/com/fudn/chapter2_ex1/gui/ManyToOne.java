package com.fudn.chapter2_ex1.gui;
import com.fudn.chapter2_ex1.configs.AppConfig;
import com.fudn.chapter2_ex1.pojos.Student;
import com.fudn.chapter2_ex1.services.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ManyToOne {

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService myService =
                context.getBean(StudentService.class);

        Student st = new Student("Lan", "Nguyen", 8);

        myService.save(st);

        context.close();
    }
}