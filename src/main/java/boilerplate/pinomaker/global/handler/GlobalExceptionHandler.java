package boilerplate.pinomaker.global.handler;


import boilerplate.pinomaker.global.dto.ErrorResponse;
import boilerplate.pinomaker.global.exception.*;
import io.jsonwebtoken.JwtException;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

import static org.springframework.http.HttpStatus.*;

/**
 * 전역 에러 처리 핸들러
 */
@Slf4j
@NoArgsConstructor
@RestControllerAdvice(basePackages = {"boilerplate.pinomaker"})
public class GlobalExceptionHandler {
    @ExceptionHandler({
            JwtException.class,
            UnAuthenticationException.class
    })
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(Exception e) {
        return errorResponse(e, UNAUTHORIZED);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            ValidationException.class,
            BadRequestException.class
    })
    public ResponseEntity<ErrorResponse> handleBadRequestException(Exception e) {
        return errorResponse(e, BAD_REQUEST);
    }

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<ErrorResponse> handleForbiddenException(Exception e) {
        return errorResponse(e, FORBIDDEN);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ErrorResponse> handleNotFoundException(Exception e) {
        return errorResponse(e, NOT_FOUND);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception e) {
        log.error("[INTERNAL SERVER ERROR] Message : " + e.getMessage());
        return errorResponse(e, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ServerException.class)
    protected ResponseEntity<ErrorResponse> handleServerException(final ServerException e) {
        log.error("handleEntityNotFoundException : " + e.getErrorCode());
        return errorResponse(e, INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> errorResponse(Exception e, HttpStatus httpStatus) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage(), httpStatus.value(), httpStatus), httpStatus);
    }
}
