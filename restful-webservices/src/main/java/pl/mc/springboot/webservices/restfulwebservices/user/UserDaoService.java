package pl.mc.springboot.webservices.restfulwebservices.user;

import lombok.val;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User(1, "Adam", new Date()),
            new User(2, "Eve", new Date()),
            new User(3, "Jack", new Date())
    ));
    private static int usersCount = users.size();

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public Optional<User> findOne(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public User deleteById(int id) {
        val iterator = users.iterator();
        while(iterator.hasNext()) {
            val user = iterator.next();
            if(user.getId().equals(id)) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
