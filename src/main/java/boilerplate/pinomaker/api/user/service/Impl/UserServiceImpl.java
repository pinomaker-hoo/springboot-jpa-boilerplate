package boilerplate.pinomaker.api.user.service.Impl;

import boilerplate.pinomaker.api.user.domain.User;
import boilerplate.pinomaker.api.user.event.dto.RequestLoginUserDto;
import boilerplate.pinomaker.api.user.event.dto.RequestSaveUserDto;
import boilerplate.pinomaker.global.jwt.TokenDto;
import boilerplate.pinomaker.global.jwt.TokenProvider;
import boilerplate.pinomaker.api.user.repository.UserJpaRepository;
import boilerplate.pinomaker.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import boilerplate.pinomaker.global.dto.RequestResponseDto;
import boilerplate.pinomaker.global.dto.UserAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserJpaRepository userJpaRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public RequestResponseDto<?> save(RequestSaveUserDto dto) {
        try {
            Optional<User> findUser = userJpaRepository.findUserById(dto.getId());
            if (findUser.isPresent()) {
                return RequestResponseDto.of(HttpStatus.BAD_REQUEST, RequestResponseDto.Code.FAILED, "이미 존재 하는 계정 입니다.", false);
            }

            User saveUser = User.builder()
                    .id(dto.getId())
                    .password(passwordEncoder.encode(dto.getPassword()))
                    .name(dto.getName())
                    .authority(UserAuthority.ROLE_USER)
                    .build();

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "회원가입 성공", userJpaRepository.save(saveUser));
        } catch (Exception e) {
            logger.info("ERROR :" + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }

    @Override
    public RequestResponseDto<?> login(RequestLoginUserDto dto) {
        try {
            Optional<User> findUser = userJpaRepository.findUserById(dto.getId());

            if (findUser.isEmpty()) {
                return RequestResponseDto.of(HttpStatus.BAD_REQUEST, RequestResponseDto.Code.FAILED, "사용자를 찾을 수 없습니다.", false);
            }

            if (!passwordEncoder.matches(dto.getPassword(), findUser.get().getPassword())) {
                return RequestResponseDto.of(HttpStatus.BAD_REQUEST, RequestResponseDto.Code.FAILED, "비밀번호가 같지 앖습니다.", false);
            }

            UsernamePasswordAuthenticationToken authenticationToken = dto.toAuthentication();
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            TokenDto tokenDto = tokenProvider.generateTokenDto(authenticationToken, "USER");

            Map<String, String> response = new HashMap<>();
            response.put("accessToken", tokenDto.getAccessToken());
            response.put("refreshToken", tokenDto.getRefreshToken());
            response.put("name", findUser.get().getName());

            return RequestResponseDto.of(HttpStatus.OK, RequestResponseDto.Code.SUCCESS, "로그인 성공 하였습니다.", response);
        } catch (Exception e) {
            logger.info("ERROR :" + e);
            return RequestResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, RequestResponseDto.Code.FAILED, e.getMessage(), null);
        }
    }
}
