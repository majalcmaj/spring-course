package pl.mc.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class RandomFortuneFromFileService implements FortuneService {

    List<String> fortunes = new ArrayList<>();
    Random rand = new Random();

    RandomFortuneFromFileService() {

    }

    @PostConstruct
    void setup() {
        System.out.println("Setup called");
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream stream = loader.getResourceAsStream("fortunes")) {
            Scanner sc = new Scanner(stream);
            while (sc.hasNextLine()) {
                fortunes.add(sc.nextLine());
            }
        } catch(IOException ex) {
            throw new RuntimeException("An exception has occurred during intialization.", ex);
        }
        System.out.println("Setup finished");
    }

    @Override
    public String getFortune() {
        return fortunes.get(rand.nextInt(fortunes.size()));
    }
}
