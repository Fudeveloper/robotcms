package com.lik.robotcms.controller;


import com.lik.robotcms.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @author lik
 */
@Controller
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysUserService sysUserSerivce;
//    @GetMapping("/login")
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("password") String password){
//        Subject currentUser = SecurityUtils.getSubject();
//        if (!currentUser.isAuthenticated()){
//            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
//            usernamePasswordToken.setRememberMe(true);
//            try{
//                currentUser.login(usernamePasswordToken);
//
//            }catch (AuthenticationException ae){
//                System.out.println("登录失败"+ae.getMessage());
//                return "login";
//            }
//
//        }
//
//        return "index";
//    }

    @GetMapping(value = "login")
    public String login(Model model, HttpServletRequest request) {
        model.addAttribute("base", request.getContextPath());
        Subject s = SecurityUtils.getSubject();
        return s.isRemembered() || s.isAuthenticated() ? "redirect:index" : "/login";
    }
//
//    @PostMapping(value = "/login")
//    public String fail(HttpServletRequest request, @RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
//        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
//        String error=(String)request.getAttribute(org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
//        if(error!=null){
//            if(error.contains("DisabledAccountException")){
//                model.addAttribute("error","用户已被屏蔽,请登录其他用户.");
//            }else if(error.contains("UnknownAccountException")){
//                model.addAttribute("error","用户不存在,请检查后重试!");
//            }else{
//                model.addAttribute("error","登录失败，请重试.");
//            }
//        }
//        return "/login";
//    }

//    @RequestMapping(value = "login",method = RequestMethod.POST)
//    @ResponseBody
//    public Result login1(SysUser sysUser){
//        Result result=null;
////        ByteSource salt = ByteSource.Util.bytes(sysUser.getName());
//
//        UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
//        //获取当前的Subject
//        Subject currentUser = SecurityUtils.getSubject();
//        try {
//            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
//            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
//            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
//            logger.info("对用户[" + sysUser.getUsername() + "]进行登录验证..验证开始");
//            currentUser.login(token);
//            logger.info("对用户[" + sysUser.getUsername() + "]进行登录验证..验证通过");
//        }catch(UnknownAccountException uae){
//            logger.info("对用户[" + sysUser.getUsername() + "]进行登录验证..验证未通过,未知账户");
//            result=new Result("未知账户","",false,0);
//        }catch(IncorrectCredentialsException ice){
//            logger.info("对用户[" + sysUser.getUsername() + "]进行登录验证..验证未通过,错误的凭证");
//            result=new Result("密码不正确","",false,0);
//        }catch(LockedAccountException lae){
//            logger.info("对用户[" + sysUser.getUsername() + "]进行登录验证..验证未通过,账户已锁定");
//            result=new Result("账户已锁定","",false,0);
//        }catch(ExcessiveAttemptsException eae){
//            logger.info("对用户[" + sysUser.getUsername() + "]进行登录验证..验证未通过,错误次数过多");
//            result=new Result("用户名或密码错误次数过多","",false,0);
//        }catch(AuthenticationException ae){
//            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
//            logger.info("对用户[" + sysUser.getUsername() + "]进行登录验证..验证未通过,堆栈轨迹如下");
//            ae.printStackTrace();
//            result=new Result("用户名或密码不正确","",false,0);
//        }
//        //验证是否登录成功
//        if(currentUser.isAuthenticated()){
//            logger.info("用户[" + sysUser.getUsername() + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
//            result=new Result("登录成功","",true,0);
//            Session session = currentUser.getSession();
//            SysUser systemUser1=sysUserSerivce.selectByUsername(sysUser.getUsername());
//            session.setAttribute("sysUser",systemUser1);
//            return result;
//        }else{
//            token.clear();
//            return result;
//        }
//    }

    @PostMapping("/login")
    public String loginHandler(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        System.out.println(username);
        System.out.println(password);
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
//            ByteSource salt = ByteSource.Util.bytes(username);
//            SimpleHash md5 = new SimpleHash("MD5", "123456", salt, 1024);
//            md5.get

            usernamePasswordToken.setRememberMe(true);

            try {
                currentUser.login(usernamePasswordToken);
            } catch (AuthenticationException ae) {
                System.out.println("登录失败" + ae.getMessage());
                return "login";
            }
        }
        return "list";
    }
}


