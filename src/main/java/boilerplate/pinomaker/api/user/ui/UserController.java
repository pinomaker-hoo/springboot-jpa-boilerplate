package boilerplate.pinomaker.api.user.ui;

import boilerplate.pinomaker.api.user.service.UserService;

import boilerplate.pinomaker.global.dto.UserDetailDto;
import boilerplate.pinomaker.global.utils.PermissionUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Tag(name = "User", description = "회원 API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/v1")
    public ResponseEntity<?> sample(HttpServletRequest request){
        UserDetailDto userDetailDto = PermissionUtils.getUserDetailDto(request);

        return userService.sample(userDetailDto);
    }
}
