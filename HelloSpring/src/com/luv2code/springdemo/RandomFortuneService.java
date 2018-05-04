package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
    private Random rand = new Random();
    private static String[] fortunes = new String[]{
            "You will have a nice day!",
            "Your day will be OK",
            "You will die and boil in hell }:-)"
    };

    @Override
    public String getFortune() {
        return fortunes[rand.nextInt() % fortunes.length];
    }
}
