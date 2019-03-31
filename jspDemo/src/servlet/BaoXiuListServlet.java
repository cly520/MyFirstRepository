package servlet;

import model.BaoXiu;
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

public class BaoXiuListServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String qname = request.getParameter("pname");
        String loudong = request.getParameter("loudong");
//        当前页码
        String pageCode = request.getParameter("pageCode");
        //        每页数据条数
        Integer pageSize = 5;
        Map<String , Object> params = new HashMap<>();
        params.put("ename",qname);
        params.put("loudong","".equals(loudong) ? null : loudong);
        params.put("pageCode",(pageCode == null || pageCode.equals(""))? "1" :pageCode);
        params.put("pageSize",pageSize);
        Page<BaoXiu> page = userService.selectBaoXiu(params);
        request.setAttribute("page",page);
        request.setAttribute("ename",qname);
        request.setAttribute("loudong","".equals(loudong) ? null : loudong);
        request.getRequestDispatcher("pages/baoxiulist.jsp").forward(request,response);
    }
}
