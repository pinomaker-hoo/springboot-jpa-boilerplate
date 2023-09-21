package boilerplate.pinomaker.service;

import boilerplate.pinomaker.common.dto.RequestResponseDto;
import boilerplate.pinomaker.dto.RequestLoginUserDto;
import boilerplate.pinomaker.dto.RequestSaveUserDto;

public interface UserService {
    RequestResponseDto<?> save(RequestSaveUserDto dto);
    RequestResponseDto<?> login(RequestLoginUserDto dto);
}
