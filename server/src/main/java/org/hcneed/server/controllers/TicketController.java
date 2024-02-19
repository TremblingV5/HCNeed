package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@Tag(name = "TicketController", description = "工单相关接口")
public class TicketController extends BaseController {

    @GetMapping("/list")
    @Operation(description = "获取所有工单列表")
    public R list() {
        return ok();
    }

    @PostMapping("/")
    @Operation(description = "创建工单")
    public R create(@RequestBody Object data) {
        return ok();
    }

    @GetMapping("/{ticketId}")
    @Operation(description = "获取对应工单信息")
    public R ticket(@PathVariable Long ticketId) {
        return ok();
    }

    @PutMapping("/{ticketId}/{type}")
    @Operation(description = "关闭或重新打开工单")
    @Parameter(name = "type", description = "type是一个枚举类型，包括open和close，含义为打开或关闭工单")
    public R active(@PathVariable Long ticketId, @PathVariable String type) {
        return ok();
    }

    @PostMapping("/{ticketId}")
    @Operation(description = "为工单增加回复")
    public R post(@PathVariable Long ticketId, @RequestBody Object data) {
        return ok();
    }
}
