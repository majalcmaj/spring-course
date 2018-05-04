package pl.mc.springboot.jpa.jpain10steps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mc.springboot.jpa.jpain10steps.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
