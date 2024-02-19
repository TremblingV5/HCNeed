package org.hcneed.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hcneed.server.common.controller.BaseController;
import org.hcneed.server.common.response.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@Tag(name = "CompanyController", description = "公司相关接口")
public class CompanyController extends BaseController {
    @GetMapping("/")
    @Operation(summary = "list", description = "获取全部公司列表")
    public R listCompany() {
        return ok();
    }

    @GetMapping("/{id}")
    @Operation(description = "获取某公司的详细信息")
    public R company(@PathVariable Long id) {
        return ok();
    }

    @PutMapping("/{id}")
    @Operation(description = "更新某公司的信息")
    public R company(@PathVariable Long id, @RequestBody Object data) {
        return ok();
    }

    @DeleteMapping("/{id}")
    @Operation(description = "删除某公司")
    public R removeCompany(@PathVariable Long id) {
        return ok();
    }

    @GetMapping("/follow/{id}")
    @Operation(description = "关注公司")
    public R follow(@PathVariable Long id) {
        return ok();
    }

}
