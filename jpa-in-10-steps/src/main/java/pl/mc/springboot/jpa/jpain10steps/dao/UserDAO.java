package pl.mc.springboot.jpa.jpain10steps.dao;

import org.springframework.stereotype.Repository;
import pl.mc.springboot.jpa.jpain10steps.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public long insertUser(User user) {
        entityManager.persist(user);
        return user.getId();
    }
}
