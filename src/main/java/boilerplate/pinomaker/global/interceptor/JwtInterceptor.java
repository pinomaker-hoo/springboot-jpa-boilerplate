package boilerplate.pinomaker.global.interceptor;

import boilerplate.pinomaker.global.jwt.JwtTokenExtractor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {
    private final JwtTokenExtractor jwtTokenExtractor;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long userId = jwtTokenExtractor.extractUserId(request);
        request.setAttribute("id", userId);
        log.info("USER ID : {}", userId);

        return true;
    }
}
