package servlet;

import model.Emp;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.CyBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class EmpAddServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       获取前台传入的数据返回一个Map集合对象
            Map<String, String[]> parameterMap = request.getParameterMap();
//       定义一个学生对象
            Emp emp = new Emp();
//         调用CyBeanUtils工具类将Map集合转化为学生对象
            CyBeanUtils.copyProperties(emp, parameterMap);
//       存储学生对象
            userService.insertEmp(emp);
            // 跳转回学生列表页面
            request.getRequestDispatcher("/empListServlet").forward(request, response);

    }
}
