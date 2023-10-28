package boilerplate.pinomaker.api.auth.service;

import boilerplate.pinomaker.api.auth.event.dto.RequestLoginUserDto;
import boilerplate.pinomaker.api.auth.event.dto.RequestSaveUserDto;
import boilerplate.pinomaker.global.exception.BadRequestException;
import boilerplate.pinomaker.global.exception.NotFoundException;
import org.springframework.http.ResponseEntity;


public interface AuthService {
    ResponseEntity<?> save(RequestSaveUserDto dto) throws BadRequestException, Exception;
    ResponseEntity<?> login(RequestLoginUserDto dto) throws NotFoundException, BadRequestException, Exception;
}
