package pl.mc.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SnowboardCoach implements Coach {

    @Value("${foo.snb_practice}")
    private String practice;

    @Autowired
    @Qualifier("randomFortuneFromFileService")
    private FortuneService fortuneService;

    public String getDailyWorkout() {
        return "Do " + practice + " for 30 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
