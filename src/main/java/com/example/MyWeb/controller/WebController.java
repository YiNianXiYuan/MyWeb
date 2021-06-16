package com.example.MyWeb.controller;

import com.example.MyWeb.entity.User;
import com.example.MyWeb.service.UserService;
import com.example.MyWeb.utils.PageBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
//import java.util.logging.Logger;

@Controller
//@Scope("singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象），默认是singleton
public class WebController {
    /**
     *分页
     */

    private User userSave = null;//保存登陆的user信息
    @Autowired
    private UserService userService;

    @RequestMapping("/page")
    public String Userspage(Integer localPage,HttpSession session) {
        PageBeanUtil<User> pageBean = userService.querypage(localPage);
        session.setAttribute("pageBeanTotalNum",pageBean.getTotalNum());
        session.setAttribute("pageBean",pageBean);
        session.setAttribute("pageBeanList",pageBean.getList());

        System.out.println(pageBean.getList());
        return "pagingQuery";
    }

    @RequestMapping(value = "/registerButton")//登录界面的注册按钮 , method = RequestMethod.POST
    public String registerButton() throws IOException {

        return "registerPage";
    }

    @RequestMapping(value = "/loginButton")//登录界面的注册按钮 , method = RequestMethod.POST
    public String loginButton() throws IOException {

        return "redirect:/";
    }

    @RequestMapping(value = "/login")//, method = RequestMethod.POST
    public String login(User user, Model model) throws IOException {
        User u = userService.userLogin(user);//判断账号密码是否正确
        if (u != null) {
            model.addAttribute("userName", u.getUsername());
            model.addAttribute("account", u.getAccount());
            userSave = u;
            return "success";
        } else {
            System.out.println("账号或密码错误！");
            return "redirect:/";//返回根目录
        }
    }

    //    @RequestMapping(value = "/login")//, method = RequestMethod.POST
//    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //实现登录功能
//        User user = new User();
//        //获取输入的账号密码
//        String account = request.getParameter("account");//Html中form表单中标签的name属性：
//        String password = request.getParameter("password");
//        user.setAccount(account);
//        user.setPassWord(password);
//
//        User u = userService.userLogin(user);//判断账号密码是否正确
//
//        System.out.println("account is:" + account);
//        System.out.println("password is:" + password);
//        if (u != null) {
////            userSave = user;
//            request.setAttribute("user", u);
//            return "success";
//        } else {
//            System.out.println("账号或密码错误！");
//            return "redirect:/";//返回根目录
//        }
//    }
    @RequestMapping(value = "/register")//注册界面判断账号是否已经存在，如果不存在则可以注册 , method = RequestMethod.POST
    public String register(User user) throws IOException {
        //判断账号密码是否正确
        if ((user.getAccount().length() > 0 && user.getAccount().length() < 16) &&
                (user.getPassWord().length() > 0 && user.getPassWord().length() < 16) &&
                (user.getPassWord().length() > 0 && user.getPassWord().length() < 16)
        ) {
            int state = userService.userRegister(user);
            if (state == 1) {
                System.out.println("注册成功！");
                return "redirect:/";
            }
            return "registerPage";
        }
        System.out.println("请按照正确的格式输入信息以便于注册");
        return "registerPage";
    }

    //    @RequestMapping(value = "/register")//注册界面判断账号是否已经存在，如果不存在则可以注册 , method = RequestMethod.POST
//    public String register(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        User user = new User();
//        //获取输入的账号密码
////        request.getparameter()获取的是name属性
//        String account = request.getParameter("account");
//        String password = request.getParameter("password");
//        String resure = request.getParameter("resure");
//        String username = request.getParameter("name");
//
//        user.setAccount(account);
//        user.setPassWord(password);
//        user.setUsername(username);
//        //判断账号密码是否正确
//        if ((account.length() > 0 && account.length() < 16) &&
//                (password.length() > 0 && password.length() < 16) &&
//                (resure.length() > 0 && resure.length() < 16)
//        ) {
//            if (password.equals(resure) && username != null) {
//                int state = userService.userRegister(user);
//                if (state == 1) {
//                    System.out.println("注册成功！");
//                    return "redirect:/";
//                }
//                return "registerPage";
//            }
//            System.out.println("请确认两次输入的密码相同！");
//            return "registerPage";
//        }
//        System.out.println("请按照正确的格式输入信息以便于注册");
//        return "registerPage";
//    }
    @RequestMapping(value = "/viewUser")//显示当前用户信息
    public String viewUser(String account, Model model) throws IOException {
        System.out.println(account);
        User user = userService.viewUser(account);
        model.addAttribute("getAccount", user.getAccount());
        model.addAttribute("getPassWord", user.getPassWord());
        model.addAttribute("getUsername", user.getUsername());
        return "viewUserInfo";
    }

    @RequestMapping(value = "/userManager")//用户管理
    public String userManager(Model model) throws IOException {
        model.addAttribute("account", userSave.getAccount());
//        System.out.println(userSave.getAccount());
        return "userManager";
    }

    @RequestMapping(value = "/viewAllUser")//显示所有用户信息
    public String viewAllUser(Model model, HttpSession session) throws IOException {
        List<User> userList = userService.viewAllUser();
        model.addAttribute("userList", userList);
        session.setAttribute("usersSession", userList);
        return "viewAllUserInfo";
    }

    @RequestMapping(value = "/userModify")//修改用户信息界面
    public String userModify(User user, Model model) throws IOException {
        if (user.getUsername() != null && user.getPassWord() != null) {
            user.setAccount(userSave.getAccount());
            System.out.println(user.getAccount() + user.getPassWord() + user.getUsername());
            int res = userService.userModify(user);
            if (res > 0) {
                System.out.println("修改成功" + res);
                return "redirect:/";//返回根目录
            }
        }
        return "userModify";
    }

    @RequestMapping(value = "/clock")//时钟界面
    public String clock() throws IOException {
        return "clock";
    }

    @RequestMapping(value = "/deleteUser")//用户注销
    public String deleteUser(String accounts, HttpSession session) throws IOException {
//        System.out.println(accounts);
        //注销账号
        int res = userService.deleteUser(accounts);
        System.out.println("res" + res);
        //同步页面的数据
        if (res > 0) {

            List<User> users = (List<User>) session.getAttribute("usersSession");
            for (User us : users) {

                if (accounts.equals(us.getAccount()))
                {
                    users.remove(us);
                    break;
                }
            }
            session.setAttribute("usersSession", users);
            if(userSave.getAccount().equals(accounts)){
                return "redirect:/";
            }
        }
        return "viewAllUserInfo";
    }

    @RequestMapping(value = "/deleteUserPage")//分页用户注销
    public String deleteUserPage(String account, HttpSession session) throws IOException {
        //注销账号
        int res = userService.deleteUser(account);
        System.out.println("res" + res + "page");
        //同步页面的数据
        if (res > 0) {
            System.out.println(account);
            PageBeanUtil pg = (PageBeanUtil) session.getAttribute("pageBean");

            Integer totalNum = pg.getTotalNum();
            int reLocalPage = totalNum - 1;
            session.setAttribute("pageBeanTotalNum",reLocalPage);//总用户数减一

            List<User> users = (List<User>) session.getAttribute("pageBeanList");
            for (User user : users) {
                if (user.getAccount().equals(account))
                {
                    System.out.println(user.getAccount()+"  "+user.getPassWord()+"  "+user.getUsername());
                    users.remove(user);
                    break;
                }
            }
            session.setAttribute("pageBeanList", users);
            if(userSave.getAccount().equals(account)){
                return "redirect:/";
            }
        }
        return "pagingQuery";
    }

    @RequestMapping(value = "/success")//登陆成功界面
    public String success(Model model) throws IOException {
        model.addAttribute("userName", userSave.getUsername());
        return "success";
    }
}

