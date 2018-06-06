package com.lik.robotcms.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author lik
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            usernamePasswordToken.setRememberMe(true);
            try{
                currentUser.login(usernamePasswordToken);

            }catch (AuthenticationException ae){
                System.out.println("登录失败"+ae.getMessage());
                return "login";
            }

        }

        return "index";
    }
}
