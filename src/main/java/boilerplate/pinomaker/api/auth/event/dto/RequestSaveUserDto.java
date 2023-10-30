package boilerplate.pinomaker.api.auth.event.dto;

import lombok.Data;

@Data
public class RequestSaveUserDto {
    private String username;
    private String password;
    private String name;
}
