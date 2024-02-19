package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Tag(name = "CommentController", description = "评论相关接口")
public class CommentController extends BaseController {

    @GetMapping("/{id}")
    @Operation(description = "获取评论")
    public R get(@PathVariable Long id) {
        return ok();
    }

    @PostMapping("/{postId}")
    @Operation(description = "新增评论")
    public R post(@PathVariable Long postId, @RequestBody Object data) {
        return ok();
    }

    @PostMapping("/{id}/re")
    @Operation(description = "二级评论")
    public R re(@PathVariable Long id, @RequestBody Object data) {
        return ok();
    }

    @DeleteMapping("/{id}")
    @Operation(description = "删除评论")
    public R delete(@PathVariable Long id) {
        return ok();
    }

    @PutMapping("/{id}")
    @Operation(description = "更新评论")
    public R update(@PathVariable Long id, @RequestBody Object data) {
        return ok();
    }

    @PutMapping("/{id}/examine")
    @Operation(description = "审核评论")
    public R examine(@PathVariable Long id, @RequestBody Object data) {
        return ok();
    }

}
