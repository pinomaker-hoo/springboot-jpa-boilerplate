package boilerplate.pinomaker.global.utils;


import boilerplate.pinomaker.global.dto.UserDetailDto;
import boilerplate.pinomaker.global.enums.UserRole;
import boilerplate.pinomaker.global.exception.UnAuthenticationException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

import static boilerplate.pinomaker.global.enums.UserRole.ROLE_ADMIN;


@Slf4j
public class PermissionUtils {

    public static UserDetailDto getUserDetailDto(HttpServletRequest httpServletRequest) {
        return (UserDetailDto) httpServletRequest.getAttribute("user");
    }

    public static UserDetailDto getAdminUserDetailDto(HttpServletRequest httpServletRequest) throws UnAuthenticationException {
        final UserDetailDto admin = (UserDetailDto) httpServletRequest.getAttribute("user");
        validateIsAdmin(admin.getRole());
        return admin;
    }

    private static void validateIsAdmin(UserRole userRole) throws UnAuthenticationException {
        if (!isAdmin(userRole)) {
            throw new UnAuthenticationException("접근 권한이 없습니다.");
        }
        log.info("Validate Is Admin Pass");
    }

    private static Boolean isAdmin(UserRole role) {
        return role.equals(ROLE_ADMIN);
    }
}
