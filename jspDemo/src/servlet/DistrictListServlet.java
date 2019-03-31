package servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DistrictListServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id == null ){
            //        调用业务层的方法返回一个结果集合 并将其强转为JSONArray
            JSONArray jsonArray = (JSONArray) JSONArray.toJSON(userService.getDistrict());
//        定义响应的编码格式
            response.setContentType("text/json;charset=utf-8");
            response.setCharacterEncoding("utf-8");
//        将jasonArray 传入到首页的ajax中
            response.getWriter().write(jsonArray.toJSONString());
        }else {
            //        调用业务层的方法返回一个结果集合 并将其强转为JSONArray
            JSONArray jsonArray = (JSONArray) JSONArray.toJSON(userService.getLouDong());
//        定义响应的编码格式
            response.setContentType("text/json;charset=utf-8");
            response.setCharacterEncoding("utf-8");
//        将jasonArray 传入到首页的ajax中
            response.getWriter().write(jsonArray.toJSONString());
        }

    }
}
