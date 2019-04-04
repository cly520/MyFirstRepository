package servlet;

import model.Emp;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmpListServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       获得前台传来的姓名和地区
        String qname = request.getParameter("pname");
        String district = request.getParameter("qdistrict");
//        获得当前页码
        String pageCode = request.getParameter("pageCode");
//        每页数据条数
            Integer pageSize = 5;
//        定义一个Map集合将前台信息存入集合内
            Map<String , Object> params = new HashMap<>();
            params.put("ename",qname);
            params.put("district","".equals(district) ? null : district);
            params.put("pageCode",(pageCode == null || pageCode.equals(""))? "1" :pageCode);
            params.put("pageSize",pageSize);
//         调用业务层方法返回一个page对象
            Page<Emp> page = userService.selectEmp(params);
//          将page对象存入请求中
            request.setAttribute("page",page);
            request.setAttribute("ename",qname);
            request.setAttribute("district","".equals(district) ? null : district);
//          请求转发
            request.getRequestDispatcher("pages/emplist.jsp").forward(request,response);
        }
    }

