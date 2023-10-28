package boilerplate.pinomaker.global.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

@ToString
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(400, "40000", "Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "40005", "Entity Not Found"),

    // OTP
    OTP_VALIDATION_ERROR(400, "40007", "OTP Validation Error"),

    // Service-code
    SERVICE_CODE_EMPTY(400, "40001", "ServiceCode Empty"),
    SERVICE_CODE_NOT_PROVIDE(400, "40002", "ServiceCode Not Provide"),
    SERVICE_CODE_DUPLICATION(409, "40902", "ServiceCode duplication"),
    INVALID_SERVICE_CODE_FORM(400, "40083", "Invalid serviceCode form"),
    SERVICE_CODE_DISABLED(403, "40303", "ServiceCode Disabled Exception"),

    // Role
    UNAUTHORIZED_USER_ROLE(403, "40300", "Unauthorized User Role"),

    // Redis
    REDIS_NOT_EXISTS_KEY(401, "40003", "Redis Not Exists Key"),
    REDIS_NOT_EXISTS_TOKEN(401, "40004", "Redis Not Exists Token"),

    METHOD_NOT_ALLOWED(405, "", "Method Not Allowed"),
    INTERNAL_SERVER_ERROR(500, "", "Server Error"),
    INVALID_TYPE_VALUE(400, "", "Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "", "Access is Denied"),

    // Member
    LOGIN_FAIL_COUNT(400, "40005", "Login Fail Count Error"),
    INVALID_OTP_VALUE(400, "40006", "Invalid OTP Value"),
    MEMBER_DISABLED_ERROR(400, "40008", "Member Disabled Error"),
    TERM_NOT_AGREE(400, "40060", "Term Not Agree"),
    MEMBER_AGE_EXCEPTION(403, "40301", "Member Age Not Adult"),
    MEMBER_DELETE_IN_PROGRESS_EXCEPTION(400, "40071", "Member Delete In Progress"),
    EMAIL_DUPLICATION(400, "40061", "Member Email Duplication"),
    INVALID_PHONE_VALUE(400, "40062", "Invalid Phone Value"),
    INVALID_PASSWORD_VALUE(400, "40063", "Invalid Password Value"),
    SOCIAL_MEMBER_CONFLICT(409, "40901", "Social Member Email Conflict"),
    SOCIAL_MEMBER_CHANGE_PASSWORD(400, "40065", "Social Member Change Password Error"),
    RECENT_DELETE_MEMBER(400, "40072", "Recent Delete Member Error"),
    LOGIN_DUPLICATION(432, "43200", "Duplicate Login"),
    EXPIRED_SESSION(433, "43300", "Expired Session"),
    JOIN_FAIL_LIMIT(434, "43400", "Join Fail Limit"),

    // EventPage
    INVALID_DATE_TIME(400, "40065", "Invalid Date Or Time"),
    DEACTIVATE_EVENT_PAGE(400, "40067", "Deactivate Event Page"),
    DUPLICATE_EVENT_PAGE(400, "40068", "Duplicate Event Page"),
    //event
    EVENT_DAILY_COUNT_LIMIT(400, "40080", "Limit By Daily Count"),
    EVENT_ALREADY_PARTICIPATE_IN(400, "40081", "Already Participate In Event"),
    EVENT_INVALID_PERIOD(400, "40082", "Invalid Event Period");

    private final String code;
    private final String message;
    private final int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
}
