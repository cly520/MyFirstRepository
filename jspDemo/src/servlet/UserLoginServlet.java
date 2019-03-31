package servlet;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.MD5Utils;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginServlet extends javax.servlet.http.HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        获取登录页面中的用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        对密码通过MD5进行加密
        password = MD5Utils.encrypt(password);
//        调用业务层的方法
        User user = userService.getUser(username,password);
//        判断
        if(user != null){
//            用户纯在，将用户存储在session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
//            请求转发到首页
            request.getRequestDispatcher("pages/home.jsp").forward(request,response);
        }
        else {
//            用户不存在 ，提示错误
            request.setAttribute("errorMsg","用户名或密码错误！！！！");
//           请求转发到登录界面
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
