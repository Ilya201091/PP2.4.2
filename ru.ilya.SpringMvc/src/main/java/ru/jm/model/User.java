package ru.jm.model;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "usernames")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NonNull
    private String firstName;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "age")
    @NonNull
    private byte age;
}
