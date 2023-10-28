package boilerplate.pinomaker.global.exception;

import boilerplate.pinomaker.global.enums.ErrorCode;

public class ServerException extends RuntimeException {

    private final ErrorCode errorCode;

    public ServerException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServerException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
