package pl.mc.springboot.webservices.restfulwebservices.user.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer id;
    private String title;
    private String content;
    private Date timestamp;
}
