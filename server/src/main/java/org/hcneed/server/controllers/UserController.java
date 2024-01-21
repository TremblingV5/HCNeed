package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.hcneed.server.entities.dto.userDto.RegisterRequest;
import org.hcneed.server.entities.models.User;
import org.hcneed.server.exceptions.UserEmailExisted;
import org.hcneed.server.services.UserService;
import org.hcneed.server.services.impls.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "用户功能接口")
public class UserController extends BaseController {
    @Resource
    private UserServiceImpl userServiceImpl;

    @GetMapping("/greet")
    @Parameter(name = "greet", description = "greet")
    public R greet() {
        return ok("greeting");
    }

    @PostMapping("/login")
    @Operation(description = "用户登陆")
    public R login() {
        return ok();
    }

    @PostMapping("/register")
    @Operation(description = "用户注册")
    public R register(@RequestBody RegisterRequest request) {
        User user = userServiceImpl.register(request.getEmail(), request.getValidateCode(), request.getPassword());
        return ok(user);
    }

    @GetMapping("/list")
    @Operation(description = "获取所有用户的列表")
    public R list() {
        return ok();
    }

    @GetMapping("/list/{type}")
    @Operation(description = "获取指定类型的所有用户的列表")
    public R list(@PathVariable String type) {
        return ok();
    }

    @GetMapping("/{id}")
    @Operation(description = "获取指定用户的所有信息")
    public R user(@PathVariable Long id) {
        return ok();
    }

    @PutMapping("/")
    @Operation(description = "用户自行更新个人信息")
    public R user(@RequestBody Object data) {
        return ok();
    }

    @PutMapping("/{id}")
    @Operation(description = "管理员侧更新个人信息")
    public R user(@PathVariable Long id, @RequestBody Object data) {
        return ok();
    }

    @PostMapping("/ban/{id}")
    @Operation(description = "封禁用户")
    public R ban(@PathVariable Long id) {
        return ok();
    }
}
