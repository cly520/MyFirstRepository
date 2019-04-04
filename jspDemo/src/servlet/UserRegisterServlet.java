package servlet;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取注册页面中输入的用户名，密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        将密码通过MD5进行加密
        password = MD5Utils.encrypt(password);
//        调用业务层方法 查询用户列表
        List<User> list = userService.selectUser();
//        定义一个判断值
        int a = 0 ;
//        遍历查询到的结果集
        for (User user : list) {
//            判断用户表中的用户名是否与输入的用户名相同
            if(user.getUsername().equals(username)){
//               相同则将a赋值为1
                a = 1;
            }
        }
        if(a != 0 ){
//            表中存在输入的用户名 在session中添加报错的提示语
            request.getSession().setAttribute("errorMsg","用户名已存在 请重新注册！！");
//            请求转发到注册界面
            request.getRequestDispatcher("register.jsp").forward(request,response);
    }
        else{
//            表中不存在输入的用户名并判断是否添加用户成功
            if(userService.insertUser(username,password)){
//                添加成功 定义response的编码格式
                response.setContentType("text/html;charset=utf-8");
                response.setCharacterEncoding("utf-8");
//                在session中添加一个成功的提示语句 并在登录界面显示
                request.getSession().setAttribute("successMsg","恭喜你！！注册成功！！");
//                重定向到登录界面
                response.sendRedirect("login.jsp");
            }else{
//                添加失败 在session中添加失败的提示语句
                request.getSession().setAttribute("errorMsg","注册失败！！！！");
                return;
            }
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
