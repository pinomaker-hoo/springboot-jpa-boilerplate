package boilerplate.pinomaker.global.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ApiResponse<T> extends ResponseEntity<Object> {
    private int status;
    private String message;
    private T data;
    private Pagination pagination;
}
