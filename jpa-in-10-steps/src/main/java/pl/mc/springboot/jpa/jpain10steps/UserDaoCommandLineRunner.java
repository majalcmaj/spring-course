package pl.mc.springboot.jpa.jpain10steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mc.springboot.jpa.jpain10steps.dao.UserDAO;
import pl.mc.springboot.jpa.jpain10steps.entity.User;


@Component
public class UserDaoCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserDaoCommandLineRunner.class);
    @Autowired
    private UserDAO userDao;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jack", "Admin");
        Long userId = userDao.insertUser(user);
        log.info("Created user with ID = " + userId);
    }
}
