package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forum")
@Tag(name = "论坛相关接口")
public class ForumController extends BaseController {

    @GetMapping("/list")
    @Operation(description = "获取论坛列表")
    public R list() {
        return ok();
    }

    @PostMapping("/")
    @Operation(description = "创建一个论坛")
    public R create(@RequestBody Object data) {
        return ok();
    }

    @GetMapping("/{id}")
    @Operation(description = "获取论坛的具体信息")
    public R get(@PathVariable Long id) {
        return ok();
    }

    @PostMapping("/{id}/tag")
    @Operation(description = "为论坛添加标签")
    public R addTag(Long id) {
        return ok();
    }

}
