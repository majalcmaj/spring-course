package pl.mc.springboot.webservices.restfulwebservices.user;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.mc.springboot.webservices.restfulwebservices.exception.ResourceNotFoundException;

import java.net.URI;
import java.util.List;

@RestController()
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        val result = userDaoService.findOne(id);
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("id - " + id);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        val user = userDaoService.deleteById(id);
        if(user == null) {
            throw new ResourceNotFoundException("No user with id = " + id);
        }
    }
}
