package pl.mc.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class)) {
            Coach theCoach = context.getBean("snowboardCoach", Coach.class);

            System.out.println(theCoach.getDailyWorkout());
            System.out.println(theCoach.getDailyFortune());
        }finally {
            System.out.println("Finishing!");
        }
    }
}
