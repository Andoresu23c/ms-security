package uisrael.ms_security.dto;

import lombok.Data;

import java.util.Date;
@Data
public class UserDTO {
    private int id;
    private String username;
    private String documentType;
    private String document;
    private String email;
    private String password;
    private Boolean status;
    private Date createdAt;
}
