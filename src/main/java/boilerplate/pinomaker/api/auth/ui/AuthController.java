package boilerplate.pinomaker.api.auth.ui;

import boilerplate.pinomaker.api.auth.event.dto.RequestLoginUserDto;
import boilerplate.pinomaker.api.auth.event.dto.RequestSaveUserDto;
import boilerplate.pinomaker.api.auth.service.AuthService;
import boilerplate.pinomaker.global.dto.SwaggerExampleValue;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "Auth", description = "Auth API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/auth")
public class AuthController {
    private final AuthService authService;

    @Operation(summary = "Local Register", description = "Local User 회원가입")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원가입 후, 로그인에 성공하였습니다.", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.REGISTER_SUCCESS_RESPONSE))),
            @ApiResponse(responseCode = "400-1", description = "이미 가입된 회원 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":400,\"message\":\"이미 가입된 회원 입니다.\"}")})),
            @ApiResponse(responseCode = "400-2", description = "중복된 닉네임 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":400,\"message\":\"중복된 닉네임 입니다..\"}")})),
            @ApiResponse(responseCode = "404", description = "중복된 닉네임 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":404,\"message\":\"작물 정보를 찾을 수 없습니다.\"}")})),
            @ApiResponse(responseCode = "500", description = SwaggerExampleValue.INTERNAL_SERVER_ERROR, content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.INTERNAL_SERVER_ERROR_REPONSE)))})
    @PostMapping()
    public ResponseEntity<?> saveUser(@Valid @RequestBody RequestSaveUserDto dto) throws Exception {
        return authService.save(dto);
    }

    @Operation(summary = "Local Register", description = "Local User 회원가입")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인에 성공하였습니다.", content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.REGISTER_SUCCESS_RESPONSE))),
            @ApiResponse(responseCode = "400-1", description = "이미 가입된 회원 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":400,\"message\":\"이미 가입된 회원 입니다.\"}")})),
            @ApiResponse(responseCode = "400-2", description = "중복된 닉네임 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":400,\"message\":\"중복된 닉네임 입니다..\"}")})),
            @ApiResponse(responseCode = "404", description = "중복된 닉네임 입니다.", content = @Content(mediaType = "application/json", examples = {@ExampleObject(value = "{\"status\":404,\"message\":\"작물 정보를 찾을 수 없습니다.\"}")})),
            @ApiResponse(responseCode = "500", description = SwaggerExampleValue.INTERNAL_SERVER_ERROR, content = @Content(mediaType = "application/json", examples = @ExampleObject(value = SwaggerExampleValue.INTERNAL_SERVER_ERROR_REPONSE)))})
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody RequestLoginUserDto dto) throws Exception {
        return authService.login(dto);
    }
}
