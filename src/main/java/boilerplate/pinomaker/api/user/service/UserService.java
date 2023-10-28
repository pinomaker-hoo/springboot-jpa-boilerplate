package boilerplate.pinomaker.api.user.service;

import boilerplate.pinomaker.api.user.event.dto.RequestLoginUserDto;
import boilerplate.pinomaker.api.user.event.dto.RequestSaveUserDto;
import boilerplate.pinomaker.global.exception.BadRequestException;
import boilerplate.pinomaker.global.exception.NotFoundException;
import org.springframework.http.ResponseEntity;


public interface UserService {
    ResponseEntity<?> save(RequestSaveUserDto dto) throws BadRequestException, Exception;
    ResponseEntity<?> login(RequestLoginUserDto dto) throws NotFoundException, BadRequestException, Exception;
}
