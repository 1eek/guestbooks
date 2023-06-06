package com.leek.guestbooks.Controller;

import com.leek.guestbooks.Service.UserServiceImple;
import com.leek.guestbooks.pojo.*;
import com.leek.guestbooks.repositories.lyReoisutiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;


@Controller
public class indexController {
    @Autowired
    lyReoisutiry lyReoisutiry;
    @Autowired
    UserServiceImple userService;

    @GetMapping(value = {"/", "login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {

        session.setAttribute("loginUser", user);
        //登录成功重定向到主页面
        return "redirect:/main.html";

    }

    //主界面

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loginUser");
        if (user != null) {

            String name = user.getName();
            String password = user.getPassword();
            user = userService.loginService(name, password);
            if (user != null) {
                ArrayList lys = (ArrayList) lyReoisutiry.findAll();
                model.addAttribute("lys", lys);
                return "home";
            }
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
        model.addAttribute("msg", "尚未登录");
        return "login";
    }

    @GetMapping("regist")
    public String registPage() {

        return "regist";

    }

    @PostMapping("/regist")
    public String registlogic(User user, HttpSession session, Model model){
//        user.setId(1L);
        user = userService.registService(user);

        if(user==null){
            model.addAttribute("msg","用户名已被使用");
            return "regist";
        }

        return "redirect:/login";
    }
    @PostMapping("/main")
    public String main(ly ly,HttpSession session,Model model){

        Date date = new Date();
        String content= ly.getContent();
        User user= (User)session.getAttribute("loginUser");
        String name = user.getName();
        ly.setContent(content);
        ly.setDate(date);
        ly.setUserName(name);
        lyReoisutiry.save(ly);

        return "redirect:/main.html";
    }

}
