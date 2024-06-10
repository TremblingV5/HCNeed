package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.hcneed.server.entities.dto.postDto.CreatePostRequest;
import org.hcneed.server.entities.models.Post;
import org.hcneed.server.services.PostService;
import org.hcneed.server.services.impls.PostServiceImpl;
import org.hcneed.server.utils.ConvertUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@Tag(name = "PostController", description = "帖子相关接口")
public class PostController extends BaseController {

    @Resource
    private PostService postService;

    @PostMapping("/")
    @Operation(description = "发表一条帖子")
    public R post(@RequestBody CreatePostRequest request) {
        Post post = ConvertUtil.sourceToTarget(request, Post.class);
        post = postService.post(post);
        return ok(post);
    }

    @GetMapping("/{id}")
    @Operation(description = "获取帖子的具体信息")
    public R get(@PathVariable Long id) {
        Post post = postService.load(id);
        return ok(post);
    }

    @PutMapping("/{id}")
    @Operation(description = "更新帖子内容")
    public R update(@PathVariable Long id, @RequestBody CreatePostRequest request) {
        Post post = ConvertUtil.sourceToTarget(request, Post.class);
        post = postService.update(id, post);
        return ok(post);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "删除帖子")
    public R delete(@PathVariable Long id) {
        return ok();
    }

}
