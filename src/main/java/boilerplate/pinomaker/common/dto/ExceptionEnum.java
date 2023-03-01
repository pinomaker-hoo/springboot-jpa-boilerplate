package boilerplate.pinomaker.common.dto;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {
    EXPIRED_JWT_EXCEPTION(HttpStatus.UNAUTHORIZED,"만료된 jwt 입니다.",0),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED,"권한이 부족합니다.",1),
    DUPLICATED_EXCEPTION(HttpStatus.CONFLICT,"이미 존재하는 값입니다.",2),
    NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND,"값이 존재하지 않습니다",3),
    METHOD_NOT_ALLOWED_EXCEPTION(HttpStatus.METHOD_NOT_ALLOWED,"존재하지 않는 메서드입니다.",4),
    BAD_REQUEST_EXCEPTION(HttpStatus.BAD_REQUEST,"값이 유효하지 않습니다.",5),
    NOT_FOUND_ID(HttpStatus.UNAUTHORIZED,"아이디를 확인 해주세요.",6),
    NOT_FOUND_PASSWORD(HttpStatus.UNAUTHORIZED,"비밀번호를 확인 해주세요.",7),
    NULL_POINT_EXCEPTION(HttpStatus.BAD_REQUEST,"??",8),
    PRECONDITION_FAILED(HttpStatus.PRECONDITION_FAILED,"처리할 수 없는 요청입니다.",9),
    REFRESH_TOKEN_EXCEPTION(HttpStatus.UNAUTHORIZED,"유효하지않은 REFRESH TOKEN 입니다.",10),
    NOT_FOUND_CATEGORY(HttpStatus.NOT_FOUND,"카테고리를 찾을 수 없습니다.",11),
    PARSER_EXCEPTION(HttpStatus.BAD_REQUEST,"날짜 또는 시간을 확인해주세요.",12),
    NOT_FOUND_PREPAID(HttpStatus.NOT_FOUND,"선불권을 찾을 수 없습니다.",13),
    NOT_FOUND_BOOKMARK(HttpStatus.NOT_FOUND,"찜을 찾을 수 없습니다.",14),
    NOT_FOUND_EMAIL(HttpStatus.UNAUTHORIZED,"이메일을 확인 해주세요.",15),
    EXPIRED_EXCEPTION(HttpStatus.UNAUTHORIZED,"접속이 만료되었습니다.",   16),
    NOT_FOUND_EVENT(HttpStatus.UNAUTHORIZED,"이벤트를 찾을 수 없습니다.",17),
    NOT_FOUND_COMMENT(HttpStatus.UNAUTHORIZED,"댓글을 찾을 수 없습니다.",18),
    NOT_FOUND_REPLY(HttpStatus.UNAUTHORIZED,"답글을 찾을 수 없습니다.",19),
    NOT_FOUND_BANNER(HttpStatus.UNAUTHORIZED,"배너를 찾을 수 없습니다.",20),
    NOT_FOUND_COUPON(HttpStatus.UNAUTHORIZED,"쿠폰을 찾을 수 없습니다.",21),
    NOT_FOUND_NOTICE(HttpStatus.UNAUTHORIZED,"공지를 찾을 수 없습니다.",22),
    NOT_FOUND_PROGRAM(HttpStatus.UNAUTHORIZED,"프로그램을 찾을 수 없습니다.",23),
    NOT_FOUND_PRODUCT(HttpStatus.UNAUTHORIZED,"제품을 찾을 수 없습니다.",24),
    NOT_FOUND_PUSH(HttpStatus.UNAUTHORIZED,"푸쉬 정보를 찾을 수 없습니다.",26),
    ANSWER_DUPLICATED_EXCEPTION(HttpStatus.CONFLICT,"이미 답변이 존재합니다.",27),
    NOT_FOUND_QUESTION(HttpStatus.UNAUTHORIZED,"질문을 찾을 수 없습니다.",28),
    NOT_FOUND_ANSWER(HttpStatus.UNAUTHORIZED,"질문을 찾을 수 없습니다.",29),
    ANSWER_DUPLICATED_EXCEPTIONS(HttpStatus.CONFLICT,"답변이 존재하여 삭제 할 수 없습니다.",30),
    DUPLICATED_EMAIL_EXCEPTION(HttpStatus.CONFLICT,"이미 존재하는 이메일 입니다.",31),
    DUPLICATED_PHONE_EXCEPTION(HttpStatus.CONFLICT,"이미 존재하는 핸드폰 번호 입니다.",32),
    EXPIRED_COUPON_EXCEPTION(HttpStatus.UNAUTHORIZED,"만료된 쿠폰 입니다.",33),
    ;

    private final HttpStatus status;
    private String message;
    private Integer errorCode;

    ExceptionEnum(HttpStatus status){
        this.status=status;
    }

    ExceptionEnum(HttpStatus status, String message, Integer errorCode){
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
    }
}
