package org.hcneed.server.common.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hcneed.server.common.response.R;
import org.hcneed.server.constants.ApiCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    /***
     * 设置上下文的请求
     *
     * @param request  请求
     * @param response 响应
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    /***
     * 获取请求的
     *
     */
    public String getParameter(String name) {
        String value = this.request.getParameter(name);
        if (value == null) {
            value = "";
        }
        return value;
    }

    public R ok() {
        return new R<>().response();
    }

    public <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setData(data);
        r.message("success");
        return r.response();
    }

    public <T> R<T> error() {
        R<T> r = new R<>();
        r.code(ApiCode.INTERNAL_SERVER_ERROR);
        r.message(ApiCode.getMessage(r.getCode()));
        return r.response();
    }

    public <T> R<T> error(int code) {
        R<T> r = new R<>();
        r.code(code);
        r.message(ApiCode.getMessage(r.getCode()));
        return r.response();
    }

    public <T> R<T> error(String msg) {
        R<T> r = new R<>();
        r.code(ApiCode.INTERNAL_SERVER_ERROR);
        r.message(msg);
        return r.response();
    }

    public <T> R<T> error(int code, String msg) {
        R<T> r = new R<>();
        r.code(code);
        r.message(msg);
        return r.response();
    }

    public void setHeaderForFile(String filename) {
        this.response.setHeader("Content-Type", "application/octet-stream");
        this.response.setHeader("Content-Disposition", "attachment; filename=" + filename);
    }
}
