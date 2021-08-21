package model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@Table(name = "list_users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Email")
    @Email
    private String email;

    @Column(name = "Age")
    private String age;

    public void setUser(User user) {
        this.id = user.id;
        this.username = user.username;
        this.age = user.age;
        this.email = user.email;
    }

}
