package pl.mc.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {
    private FortuneService fortuneService;

    @Autowired
    public TennisCoach(@Qualifier("databaseFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Practice your backhand volley.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @PostConstruct
    void setup() {
        System.out.println("Tennis coach's setup called");
    }


    @PreDestroy
    void dispose() {
        System.out.println("Tennis coach's dispose called");
    }
}
