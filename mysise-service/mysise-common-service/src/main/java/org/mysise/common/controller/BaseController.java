package org.mysise.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  公共处理controller
 * <p>
 *
 * @author FanWenJie
 * @since 2020/5/7 0:45
 */
@RestController
public class BaseController implements ErrorController {


    @Autowired
    HttpServletRequest request;

    @Override
    @GetMapping("/error")
    public String getErrorPath() {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return "没找到相应请求";
    }
}
