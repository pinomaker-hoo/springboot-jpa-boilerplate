package boilerplate.pinomaker.global.jwt;

import boilerplate.pinomaker.global.exception.UnAuthenticationException;
import boilerplate.pinomaker.global.utils.EncryptionUtils;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * JWT 토큰에 있는 유저 정보 추출 클래스
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenExtractor {
    private final JwtTokenValidator jwtTokenValidator;
    private final EncryptionUtils encryptionUtils;
    private static final String AUTHORIZATION_KEY = "Authorization";

    public Long extractUserId(HttpServletRequest request) throws Exception {
        String jwt = getAuthorizationToken(request);

        Claims claims = jwtTokenValidator.getClaimsFromToken(jwt);

        String encodedUserId = String.valueOf(claims.get("id"));

        Long userId = Long.valueOf(encryptionUtils.decrypt(encodedUserId));

        return userId;
    }

    /**
     * Header Check
     */
    public String getAuthorizationToken(HttpServletRequest request) throws Exception {
        String token = getRequestToken(request);

        if (token == null) {
            throw new UnAuthenticationException("JWT 토큰이 잘못되었습니다");
        }
        if (!StringUtils.hasText(token)) {
            throw new UnAuthenticationException("JWT 토큰이 잘못되었습니다");
        }
        if (!token.startsWith("Bearer ")) {
            throw new UnAuthenticationException("JWT 토큰이 잘못되었습니다");
        }

        final String jwt = token.substring(7);
        jwtTokenValidator.validateToken(jwt);
        return jwt;
    }

    public String getRequestToken(HttpServletRequest request) {
        if (request.getParameter(AUTHORIZATION_KEY) == null) {
            return request.getHeader(AUTHORIZATION_KEY);
        }
        return request.getParameter(AUTHORIZATION_KEY);
    }

}
