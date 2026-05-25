package com.fudn.chapter2_ex1.configs;

import com.fudn.chapter2_ex1.aspects.LoggingAspect;
import com.fudn.chapter2_ex1.services.StudentService;
import com.fudn.chapter2_ex1.services.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public StudentService myService(){
        return new StudentServiceImpl();
    }
    @Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}
