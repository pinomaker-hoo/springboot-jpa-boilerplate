package boilerplate.pinomaker.api.user.ui;

import boilerplate.pinomaker.api.user.event.dto.RequestLoginUserDto;
import boilerplate.pinomaker.api.user.event.dto.RequestSaveUserDto;
import boilerplate.pinomaker.api.user.service.UserService;
import boilerplate.pinomaker.global.dto.SwaggerExampleValue;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원가입 후, 로그인에 성공하였습니다.", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.REGISTER_SUCCESS_RESPONSE))),
            @ApiResponse(responseCode = "400-1", description = "이미 가입된 회원 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":400,\"message\":\"이미 가입된 회원 입니다.\"}")})),
            @ApiResponse(responseCode = "400-2", description = "중복된 닉네임 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":400,\"message\":\"중복된 닉네임 입니다..\"}")})),
            @ApiResponse(responseCode = "404", description = "중복된 닉네임 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":404,\"message\":\"작물 정보를 찾을 수 없습니다.\"}")})),
            @ApiResponse(responseCode = "500", description = SwaggerExampleValue.INTERNAL_SERVER_ERROR, content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.INTERNAL_SERVER_ERROR_REPONSE)))})
    @PostMapping()
    public ResponseEntity<?> saveUser(@RequestBody RequestSaveUserDto dto) throws Exception {
        return userService.save(dto);
    }

    @Operation(summary = "Local Register", description = "Local User 회원가입")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인에 성공하였습니다.", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.REGISTER_SUCCESS_RESPONSE))),
            @ApiResponse(responseCode = "400-1", description = "이미 가입된 회원 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":400,\"message\":\"이미 가입된 회원 입니다.\"}")})),
            @ApiResponse(responseCode = "400-2", description = "중복된 닉네임 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":400,\"message\":\"중복된 닉네임 입니다..\"}")})),
            @ApiResponse(responseCode = "404", description = "중복된 닉네임 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":404,\"message\":\"작물 정보를 찾을 수 없습니다.\"}")})),
            @ApiResponse(responseCode = "500", description = SwaggerExampleValue.INTERNAL_SERVER_ERROR, content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.INTERNAL_SERVER_ERROR_REPONSE)))})
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RequestLoginUserDto dto) throws Exception {
        return userService.login(dto);
    }
}
