package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@Tag(name = "帖子相关接口")
public class PostController extends BaseController {

    @PostMapping("/")
    @Operation(description = "发表一条帖子")
    public R post(@RequestBody Object data) {
        return ok();
    }

    @GetMapping("/{id}")
    @Operation(description = "获取帖子的具体信息")
    public R get(@PathVariable Long id) {
        return ok();
    }

    @PutMapping("/{id}")
    @Operation(description = "更新帖子内容")
    public R update(@PathVariable Long id, @RequestBody Object data) {
        return ok();
    }

    @DeleteMapping("/{id}")
    @Operation(description = "删除帖子")
    public R delete(@PathVariable Long id) {
        return ok();
    }

}
