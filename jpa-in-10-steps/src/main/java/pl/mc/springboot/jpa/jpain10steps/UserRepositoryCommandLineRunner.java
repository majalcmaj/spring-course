package pl.mc.springboot.jpa.jpain10steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mc.springboot.jpa.jpain10steps.dao.UserRepository;
import pl.mc.springboot.jpa.jpain10steps.entity.User;

import java.util.List;
import java.util.Optional;


@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jill", "Admin");
        userRepository.save(user);
        log.info("Created user with ID = " + user.getId());
        Optional<User> userWithIdOne =  userRepository.findById(1L);
        log.info("Retrieved user with ID = 1 :" + userWithIdOne);
        List<User> users = userRepository.findAll();
        log.info("Retrieved all users :" + users);
    }
}
