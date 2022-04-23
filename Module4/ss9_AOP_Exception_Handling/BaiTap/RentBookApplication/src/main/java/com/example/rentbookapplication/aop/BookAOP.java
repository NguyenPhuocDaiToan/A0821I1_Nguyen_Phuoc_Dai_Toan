package com.example.rentbookapplication.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAOP {
    @After("execution(public * com.example.rentbookapplication.controller.BookController.*(..))")
    public void writeLog() {
        System.out.println("Rent book");
    }
}
