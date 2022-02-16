package com.lhb.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lhb
 * @date 2021/2/15 13:58
 */
@Controller
public class IndexController {
    @RequestMapping("toUpload")
    public String toUpload(){
        return "toUpload";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "toLogin";
    }

    @RequestMapping("success")
    public String success(){
        return "success";
    }

    @RequestMapping("index")
    public String index1(){
        return "index";
    }
}
