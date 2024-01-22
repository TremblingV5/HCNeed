package org.hcneed.server.entities.dto.userDto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

@Data
@Tag(name = "用户登陆请求体")
public class LoginRequest {

    @Parameter(name = "email", description = "邮箱地址，用于登录")
    private String email;

    @Parameter(name = "password", description = "密码")
    private String password;

}
