package pl.mc.springboot.webservices.restfulwebservices.user;

import lombok.*;
import pl.mc.springboot.webservices.restfulwebservices.user.post.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;


@Data
public class User {
    private List<Post> posts;
    private Integer id;
    private String name;
    private Date birthDate;

    public User(Integer id, String name, Date birthDate) {
        this();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public User() {
        this.posts = new ArrayList<>();
    }
}
