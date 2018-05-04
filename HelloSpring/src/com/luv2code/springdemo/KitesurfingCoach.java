package com.luv2code.springdemo;

public class KitesurfingCoach implements Coach{

    private FortuneService fortuneService;

    public KitesurfingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice jumping transition!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
