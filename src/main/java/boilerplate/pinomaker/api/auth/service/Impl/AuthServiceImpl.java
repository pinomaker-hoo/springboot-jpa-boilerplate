package boilerplate.pinomaker.api.auth.service.Impl;

import boilerplate.pinomaker.api.auth.event.dto.RequestLoginUserDto;
import boilerplate.pinomaker.api.auth.event.dto.RequestSaveUserDto;
import boilerplate.pinomaker.api.auth.service.AuthService;
import boilerplate.pinomaker.api.user.domain.User;
import boilerplate.pinomaker.global.dto.CommonResponse;
import boilerplate.pinomaker.global.dto.TokenDto;
import boilerplate.pinomaker.global.exception.BadRequestException;
import boilerplate.pinomaker.global.exception.NotFoundException;
import boilerplate.pinomaker.global.jwt.TokenProvider;
import boilerplate.pinomaker.api.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import boilerplate.pinomaker.global.dto.UserAuthority;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class AuthServiceImpl implements AuthService {
    private final UserJpaRepository userJpaRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> save(RequestSaveUserDto dto) throws Exception {
        Optional<User> findUser = userJpaRepository.findUserById(dto.getId());

        if (findUser.isPresent()) {
            throw new BadRequestException("이미 존재하는 계정 입니다.");
        }

        userJpaRepository.save(User.builder()
                .id(dto.getId())
                .password(passwordEncoder.encode(dto.getPassword()))
                .name(dto.getName())
                .authority(UserAuthority.ROLE_USER)
                .build());

        return CommonResponse.createResponseMessage(HttpStatus.OK.value(), "회원가입에 성공하였습니다.");
    }

    @Override
    public ResponseEntity<?> login(RequestLoginUserDto dto) throws Exception {

        Optional<User> findUser = userJpaRepository.findUserById(dto.getId());

        if (findUser.isEmpty()) {
            throw new NotFoundException("사용자를 찾을 수 없습니다.");
        }

        if (!passwordEncoder.matches(dto.getPassword(), findUser.get().getPassword())) {
            throw new BadRequestException("비밀번호가 같지 않습니다.");
        }

        UsernamePasswordAuthenticationToken authenticationToken = dto.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        TokenDto tokenDto = tokenProvider.generateTokenDto(authenticationToken, "USER");

        Map<String, String> response = new HashMap<>();
        response.put("accessToken", tokenDto.getAccessToken());
        response.put("refreshToken", tokenDto.getRefreshToken());
        response.put("name", findUser.get().getName());

        return CommonResponse.createResponse(HttpStatus.OK.value(), "로그인에 성공하였습니다.", response);
    }
}
