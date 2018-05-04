package pl.mc.springboot.webservices.restfulwebservices.user.post;

import org.springframework.stereotype.Component;
import pl.mc.springboot.webservices.restfulwebservices.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PostDaoService {
    private static int postId = 0;
    public Post createPostForUser(User user, Post post) {
        if(post.getId() == null) {
            post.setId(++postId);
        }
        user.getPosts().add(post);
        return post;
    }

    public Optional<Post> getPostForuser(User user, int postId) {
        return user.getPosts().stream().filter(post -> post.getId() == postId).findFirst();
    }

    public List<Post> findAllPostsForUser(User user) {
        return user.getPosts();
    }
}
