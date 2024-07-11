package uisrael.ms_security.dto;

import lombok.Data;

import java.util.Date;
@Data
public class RoleDTO {
    private int id;
    private String name;
    private Date createdAt;
    private Boolean status;
}
