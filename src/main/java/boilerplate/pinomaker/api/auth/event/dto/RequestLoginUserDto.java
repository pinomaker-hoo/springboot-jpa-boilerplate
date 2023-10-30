package boilerplate.pinomaker.api.auth.event.dto;

import lombok.Data;

@Data
public class RequestLoginUserDto {
    private String username;
    private String password;
}
