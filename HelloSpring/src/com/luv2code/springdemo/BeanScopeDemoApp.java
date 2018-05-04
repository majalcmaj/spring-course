package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml")) {
            Coach theCoach = context.getBean("myCoach", Coach.class);
            Coach alphaCoach = context.getBean("myCoach", Coach.class);

            System.out.println("theCoach and alphaCoach are the same object: " + (theCoach == alphaCoach));
        }catch(Exception ex) {
            System.err.println("OUCH!" + ex);
        }
    }
}
