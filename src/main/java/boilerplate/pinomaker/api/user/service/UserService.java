package boilerplate.pinomaker.api.user.service;

import boilerplate.pinomaker.global.dto.UserDetailDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> sample(UserDetailDto dto);
}
