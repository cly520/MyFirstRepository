package servlet;

import model.BaoXiu;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.CyBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class BaoXiuAddServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        BaoXiu baoXiu = new BaoXiu();
        CyBeanUtils.copyProperties(baoXiu, parameterMap);
//       存储报修对象
        userService.insertBaoXiu(baoXiu);
        // 跳转回学生报修列表页面
        request.getRequestDispatcher("/baoXiuListServlet").forward(request, response);
    }
}
