package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/captcha")
@Tag(name = "验证码相关接口")
public class CaptchaController extends BaseController {

    @PostMapping("/email")
    @Operation(description = "向邮箱发送验证码")
    public R email(@RequestBody Object data) {
        return ok();
    }

}
