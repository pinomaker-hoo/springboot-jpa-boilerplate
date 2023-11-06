package boilerplate.pinomaker.api.user.service.Impl;

import boilerplate.pinomaker.api.user.repository.UserJpaRepository;
import boilerplate.pinomaker.api.user.service.UserService;
import boilerplate.pinomaker.global.dto.CommonResponse;
import boilerplate.pinomaker.global.dto.UserDetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userJpaRepository;

    @Override
    public ResponseEntity<?> sample(UserDetailDto dto) {
        log.info("유저 권한 : {}", dto.getRole());
        log.info("유저 id : {}", dto.getUserId());

        return CommonResponse.createResponseMessage(HttpStatus.OK.value(), "샘플 API 입니다.");
    }
}
