package org.hcneed.server.controllers;

import cn.dev33.satoken.stp.StpUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.hcneed.server.entities.models.Position;
import org.hcneed.server.entities.models.relations.UserFollowPosition;
import org.hcneed.server.services.impls.PositionServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@Tag(name = "PositionController", description = "职位相关接口")
public class PositionController extends BaseController {
    @Resource
    private PositionServiceImpl positionServiceImpl;

    @GetMapping("/")
    @Operation(description = "获取全部职位列表")
    public R list() {
        List<Position> positions = positionServiceImpl.list();
        return ok(positions);
    }

    @GetMapping("/{id}")
    @Operation(description = "获取某职位的详细信息")
    public R position(@PathVariable Long id) {
        Position position = positionServiceImpl.load(id);
        return ok(position);
    }

    @PutMapping("/{id}")
    @Operation(description = "更新某职位的信息")
    public R position(@PathVariable Long id, @RequestBody Object data) {
        return ok();
    }

    @DeleteMapping("/{id}")
    @Operation(description = "删除某职位")
    public R removePosition(@PathVariable Long id) {
        positionServiceImpl.delete(id);
        return ok();
    }

    @GetMapping("/follow/{id}")
    @Operation(description = "关注职位")
    public R follow(@PathVariable Long id) {
        Long userId = (Long) StpUtil.getLoginId();
        UserFollowPosition userFollowPosition = positionServiceImpl.follow(id, userId);
        return ok(userFollowPosition);
    }

}
