package boilerplate.pinomaker.api.user.service;

import boilerplate.pinomaker.api.user.event.dto.RequestLoginUserDto;
import boilerplate.pinomaker.api.user.event.dto.RequestSaveUserDto;
import boilerplate.pinomaker.global.dto.RequestResponseDto;


public interface UserService {
    RequestResponseDto<?> save(RequestSaveUserDto dto);
    RequestResponseDto<?> login(RequestLoginUserDto dto);
}
