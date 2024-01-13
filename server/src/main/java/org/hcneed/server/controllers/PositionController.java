package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/position")
@Tag(name = "职位相关接口")
public class PositionController extends BaseController {

    @GetMapping("/")
    @Operation(description = "获取全部职位列表")
    public R list() {
        return ok();
    }

    @GetMapping("/{id}")
    @Operation(description = "获取某职位的详细信息")
    public R position(@PathVariable Long id) {
        return ok();
    }

    @PutMapping("/{id}")
    @Operation(description = "更新某职位的信息")
    public R position(@PathVariable Long id, @RequestBody Object data) {
        return ok();
    }

    @DeleteMapping("/{id}")
    @Operation(description = "删除某职位")
    public R removePosition(@PathVariable Long id) {
        return ok();
    }

    @GetMapping("/follow/{id}")
    @Operation(description = "关注职位")
    public R follow(@PathVariable Long id) {
        return ok();
    }

}
