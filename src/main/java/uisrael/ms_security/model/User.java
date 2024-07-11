package uisrael.ms_security.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false, length = 3)
    private String documentType;

    @Column(nullable = false, length = 15)
    private String document;

    @Column(nullable = false, length = 80)
    private String email;

    @Column(nullable = false, length = 25)
    private String password;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private Date createdAt;
}
