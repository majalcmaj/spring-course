package pl.mc.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class WindsurfCoach implements Coach {
    private FortuneService fortuneService;

    @Autowired
    @Qualifier("randomFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("FortuneService setter called for Windsurf Coach");
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Parctice duck gybe.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
