package org.hcneed.server.entities.dto.userDto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Tag(name = "用户注册请求体")
public class RegisterRequest {

    @Parameter(name = "email", description = "邮箱地址，用于登录")
    private String email;

    @JsonAlias("validate_code")
    @Parameter(name = "validate_code", description = "邮箱验证码")
    private String validateCode;

    @Parameter(name = "password", description = "密码")
    private String password;

}
