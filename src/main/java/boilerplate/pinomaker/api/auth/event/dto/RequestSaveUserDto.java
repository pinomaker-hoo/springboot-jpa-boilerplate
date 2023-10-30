package boilerplate.pinomaker.api.auth.event.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestSaveUserDto {
    @NotNull
    @Schema(example = "admin")
    private String username;

    @NotNull
    @Schema(example = "1234")
    private String password;

    @NotNull
    @Schema(example = "admin")
    private String name;
}
