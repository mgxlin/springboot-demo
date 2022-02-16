package com.lhb.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author lhb
 * @date 2021/2/16 9:05
 */
@Controller
public class LoginController {
    @RequestMapping("login")
    public String login(String username, String password, HttpSession session){
        if ("awei".equals(username) && "123".equals(password)){
            session.setAttribute("user",username);
            return "redirect:index";
        }else {
            session.setAttribute("msg","用户名或密码错误");
            return "redirect:toLogin";
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "toLogin";
    }
}
