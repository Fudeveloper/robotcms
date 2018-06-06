package com.lik.robotcms.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户与角色对应关系 前端控制器
 * </p>
 *
 * @author lik123
 * @since 2018-06-06
 */
@RestController
@RequestMapping("/sysUserRole")
public class SysUserRoleController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return null;
    }

    @GetMapping("/123")
    public String test(){
        return "12345";
    }
}

