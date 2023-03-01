package boilerplate.pinomaker.user.service;

import boilerplate.pinomaker.common.dto.RequestResponseDto;
import boilerplate.pinomaker.user.dto.RequestLoginUserDto;
import boilerplate.pinomaker.user.dto.RequestSaveUserDto;

public interface UserService {
    RequestResponseDto<?> save(RequestSaveUserDto dto);
    RequestResponseDto<?> login(RequestLoginUserDto dto);
}
