package boilerplate.pinomaker.common.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class CommonResponse {
    public static ResponseEntity<Object> createResponseMessage(final int statusCode, final String message) {
        return ApiResponse.builder().status(statusCode).message(message).data(null).buildObject();
    }

    public static ResponseEntity<Object> createResponse(final int statusCode, final String message, Object data) {
        return ApiResponse.builder().status(statusCode).message(message).data(data).buildObject();
    }

    public static ResponseEntity<Object> createResponseWithPagination(final int statusCode, final String message, Object data, Pagination pagination) {
        return ApiResponse.builder().status(statusCode).message(message).data(data).paging(pagination).buildObject();
    }

    public static ResponseEntity<Object> createNotFoundException(final String message) {
        log.error("[NOT FOUND:404] : {}", message);
        return ApiResponse.<Object>builder().status(HttpStatus.NOT_FOUND).message(message).buildObject();
    }

    public static ResponseEntity<Object> createBadRequestException(final String message) {
        log.error("[BAD REQUEST:400] : {}", message);
        return ApiResponse.<Object>builder().status(HttpStatus.BAD_REQUEST).message(message).buildObject();
    }
}
