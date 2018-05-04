package pl.mc.springboot.jpa.jpain10steps.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class User {
    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String role;
}
