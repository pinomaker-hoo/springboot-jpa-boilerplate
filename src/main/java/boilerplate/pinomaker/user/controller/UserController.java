package boilerplate.pinomaker.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import boilerplate.pinomaker.common.dto.RequestResponseDto;
import boilerplate.pinomaker.user.dto.RequestLoginUserDto;
import boilerplate.pinomaker.user.dto.RequestSaveUserDto;
import boilerplate.pinomaker.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "회원 API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Local Register", description = "Local User 회원가입")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping()
    public RequestResponseDto<?> saveUser(@RequestBody RequestSaveUserDto dto) {
        return userService.save(dto);
    }

    @Operation(summary = "Local Register", description = "Local User 회원가입")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/login")
    public RequestResponseDto<?> login(@RequestBody RequestLoginUserDto dto) {
        return userService.login(dto);
    }
}
