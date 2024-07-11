package uisrael.ms_security.dto;

import lombok.Data;

@Data
public class Response<T> {
    private String id;
    private String type;
    private T data;
    private String message;
    public Response() {}
    public Response(String id, String type, T data, String message) {
        this.id = id;
        this.type = type;
        this.data = data;
        this.message = message;
    }
}
