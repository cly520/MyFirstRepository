package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
//          获取请求uri
        String uri = request.getRequestURI();
//          放行静态资源
        if(uri.contains("/css/") || uri.contains("/js/") || uri.contains("/images/")){
            chain.doFilter(request,response);
            return;
        }
//          放行特殊请求 (登陆,退出,首页,注册，登陆页面,注册页面)
        if(uri.equals("/userLoginServlet") || uri.equals("/userExistServlet") ||
                uri.equals("/login.jsp") || uri.equals("/") ||  uri.equals("/register.jsp") || uri.equals("/userRegisterServlet")){
            chain.doFilter(request,response);
            return;
        }
//           获取session用户
        User user = (User) request.getSession().getAttribute("user");
//           用户不为空 放行
        if(user != null) {
            chain.doFilter(req, resp);
        }else {
            request.setAttribute("errorMsg","您还没有登陆系统!!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
    }
}