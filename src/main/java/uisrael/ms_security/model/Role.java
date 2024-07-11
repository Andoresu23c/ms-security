package uisrael.ms_security.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "\"role\"")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Boolean status;
}
