package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hcneed.server.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "用户功能接口")
public class UserController {

    @GetMapping("/greet")
    @Parameter(name = "greet", description = "greet")
    public R greet() {
        return R.ok().data("greeting").response();
    }

}
