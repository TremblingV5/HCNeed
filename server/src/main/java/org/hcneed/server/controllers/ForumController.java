package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum")
@Tag(name = "论坛相关接口")
public class ForumController extends BaseController {

    @GetMapping("/")
    @Operation(description = "获取论坛列表")
    public R list() {
        return ok();
    }

}
