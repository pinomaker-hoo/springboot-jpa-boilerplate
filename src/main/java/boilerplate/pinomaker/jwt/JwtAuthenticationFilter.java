package boilerplate.pinomaker.jwt;

import boilerplate.pinomaker.common.dto.ApiResponse;
import boilerplate.pinomaker.common.dto.ErrorMessage;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private TokenProvider tokenProvider;

    public JwtAuthenticationFilter(final TokenProvider tokenProvider) {
        super();
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        Optional<String> optToken = tokenProvider.resolveToken(request);
        try {
            if (optToken.isPresent() && tokenProvider.validateToken(optToken.get())) {
                Authentication auth = tokenProvider.getAuthentication(optToken.get());
                if (auth != null) {
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    filterChain.doFilter(new RequestWrapper(request), response);
                }
            } else {
                filterChain.doFilter(new RequestWrapper(request), response);
            }


        } catch (JwtException e) {
            logger.error("JWT token is invalid: {}", e.getMessage());
            if (e instanceof ExpiredJwtException) {
                ApiResponse.<Object>builder().status(HttpStatus.UNAUTHORIZED.value())
                        .code(ErrorMessage.TOKEN_EXPIRED.getCode()).message(ErrorMessage.TOKEN_EXPIRED.getMessage())
                        .init().writeJson(response);
            } else {
                ApiResponse.<Object>builder().status(HttpStatus.UNAUTHORIZED.value())
                        .code(ErrorMessage.TOKEN_INVALID.getCode()).message(ErrorMessage.TOKEN_INVALID.getMessage())
                        .init().writeJson(response);
            }
        } catch (Exception e) {
            logger.error("Exception - error while validating token", e.getCause());
            ApiResponse.<Object>builder().status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .code(ErrorMessage.API500001.getCode()).message(ErrorMessage.API500001.getMessage())
                    .init().writeJson(response);
        }
    }
}