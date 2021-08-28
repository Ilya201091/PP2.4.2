package ru.jm.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name="roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NonNull
    @Column(name = "role")
    private String roleName;


    @Override
    public String getAuthority() {
        return roleName;
    }

    public Role(@NonNull String roleName) {
        this.roleName = roleName;
    }
}
