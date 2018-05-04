package pl.mc.springboot.webservices.restfulwebservices.user.post;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.mc.springboot.webservices.restfulwebservices.exception.ResourceNotFoundException;
import pl.mc.springboot.webservices.restfulwebservices.user.User;
import pl.mc.springboot.webservices.restfulwebservices.user.UserDaoService;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController()
public class PostResource {

    @Autowired
    private UserDaoService userDaoService;
    @Autowired
    private PostDaoService postDaoService;

    private User getUserFromDb(int userId) {
        val userOptional = userDaoService.findOne(userId);
        if(userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new ResourceNotFoundException("No user with id = " + userId);
        }
    }

    @GetMapping("/users/{userId}/posts")
    public List<Post> retrieveAllPostsForUser(@PathVariable int userId) {
        return postDaoService.findAllPostsForUser(getUserFromDb(userId));
    }

    @GetMapping("/users/{userId}/posts/{postId}")
    public Post getUser(@PathVariable int userId, @PathVariable int postId) {
        val user = getUserFromDb(userId);
        val postOptional = postDaoService.getPostForuser(user, postId);
        if(postOptional.isPresent()) {
            return postOptional.get();
        } else {
            throw new ResourceNotFoundException(String.format("No post with id = %d for user with id %d", postId, userId));
        }
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Object> createUser(@PathVariable int userId, @RequestBody Post post) {
        val user = getUserFromDb(userId);
        postDaoService.createPostForUser(user, post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
