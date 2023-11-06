package boilerplate.pinomaker.global.dto;

import boilerplate.pinomaker.global.enums.UserRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailDto {
    private Long userId;
    private UserRole role;
}
