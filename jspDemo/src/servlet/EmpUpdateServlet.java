package servlet;

import model.Emp;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpUpdateServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获得要修改信息对应的id
        int id = Integer.parseInt(request.getParameter("id"));
//       调用业务层方法 返回一个学生对象
        Emp emp = userService.getId(id);
//      将学生对象存入请求中
        request.setAttribute("emp",emp);
        request.getRequestDispatcher("pages/empupdate.jsp").forward(request,response);
    }
}
