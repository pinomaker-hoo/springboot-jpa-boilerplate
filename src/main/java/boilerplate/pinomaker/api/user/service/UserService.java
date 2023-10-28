package boilerplate.pinomaker.api.user.service;

import boilerplate.pinomaker.api.user.event.dto.RequestLoginUserDto;
import boilerplate.pinomaker.api.user.event.dto.RequestSaveUserDto;
import org.springframework.http.ResponseEntity;


public interface UserService {
    ResponseEntity<?> save(RequestSaveUserDto dto);
    ResponseEntity<?> login(RequestLoginUserDto dto);
}
