package com.example.MyWeb.controller;

import com.example.MyWeb.entity.User;
import com.example.MyWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.util.logging.Logger;

@Controller
//@Scope("singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public class WebController {

    @Autowired
    private UserService userService;

//    private User userSave;//将登录时的信息保存起来

//    private Logger logger = Logger.getLogger(String.valueOf(WebController.class));

    @RequestMapping(value = "/registerButton")//登录界面的注册按钮 , method = RequestMethod.POST
    public String registerButton(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return "registerPage";
    }

    @RequestMapping(value = "/loginButton")//登录界面的注册按钮 , method = RequestMethod.POST
    public String loginButton(HttpServletRequest request, HttpServletResponse response) throws IOException {

        return "redirect:/";
    }

    @RequestMapping(value = "/login")//, method = RequestMethod.POST
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //实现登录功能
        User user = new User();
        //获取输入的账号密码
        String account = request.getParameter("account");//Html中form表单中标签的name属性：
        String password = request.getParameter("password");
        user.setAccount(account);
        user.setPassWord(password);

        User u = userService.userLogin(user);//判断账号密码是否正确

        System.out.println("account is:" + account);
        System.out.println("password is:" + password);
        if (u != null) {
//            userSave = user;
            request.setAttribute("user", u);
            return "success";
        } else {
            System.out.println("账号密码错误！");
            return "redirect:/";//返回根目录
        }
    }

    @RequestMapping(value = "/register")//注册界面判断账号是否已经存在，如果不存在则可以注册 , method = RequestMethod.POST
    public String register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        //获取输入的账号密码
//        request.getparameter()获取的是name属性
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String resure = request.getParameter("resure");
        String username = request.getParameter("name");

        user.setAccount(account);
        user.setPassWord(password);
        user.setUsername(username);
        //判断账号密码是否正确
        if ((account.length() > 0 && account.length() < 16) &&
                (password.length() > 0 && password.length() < 16) &&
                (resure.length() > 0 && resure.length() < 16)
        ) {
            if (password.equals(resure) && username != null) {
                int state = userService.userRegister(user);
                if (state == 1) {
                    System.out.println("注册成功！");
                    return "redirect:/";
                }
                return "registerPage";
            }
            System.out.println("请确认两次输入的密码相同！");
            return "registerPage";
        }
        System.out.println("请按照正确的格式输入信息以便于注册");
        return "registerPage";
    }

    @RequestMapping(value = "/clock")//时钟界面
    public String clock(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "clock";
    }

    @RequestMapping(value = "/success")//登陆成功界面
    public String success(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "success";
    }
}

