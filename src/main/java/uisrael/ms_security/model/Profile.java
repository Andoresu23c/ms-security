package uisrael.ms_security.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"profile\"")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;
}
