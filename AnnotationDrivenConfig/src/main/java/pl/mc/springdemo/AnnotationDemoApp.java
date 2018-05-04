package pl.mc.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Coach theCoach = context.getBean("snowboardCoach", Coach.class);

            System.out.println(theCoach.getDailyWorkout());
            System.out.println(theCoach.getDailyFortune());
        }finally {
            System.out.println("Finishing!");
        }
    }
}
