package com.my.servlet;

import com.my.domain.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by admin on 2017/6/22.
 */
@WebServlet("/TestQueryServlet")
public class TestQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收请求....");
        //设置请求数据的编码方式
        req.setCharacterEncoding("UTF-8");
        //设置响应的编码方式
        resp.setCharacterEncoding("UTF-8");

        String name=req.getParameter("userName");
        String sex=req.getParameter("sex");
        String age=req.getParameter("age");

        System.out.println(name+":"+sex+":"+age);
        User user=new User(name,sex,Integer.parseInt(age));
        //将实体对象转换为JSON对象
        JSONObject json= JSONObject.fromObject(user);
        //将JSON对象以JSON字符串的形式再响应给客户端
        PrintWriter out=resp.getWriter();
        out.print(json.toString());
        out.flush();
        out.close();
    }
}
