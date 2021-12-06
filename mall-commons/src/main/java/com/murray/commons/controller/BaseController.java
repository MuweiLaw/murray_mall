package com.murray.commons.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 基础控制器
 *
 * @author Murray Law
 * @date 2021/12/3 16:15
 */

@CrossOrigin(
        originPatterns = {"*"},
        allowCredentials = "true",
        allowedHeaders = {"*"},
        methods = {}
)
public class BaseController {
    public BaseController() {
    }
}