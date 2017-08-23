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
 * Created by admin on 2017/6/23.
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求数据的编码方式
        req.setCharacterEncoding("UTF-8");
        String user=req.getParameter("user");
        System.out.println(user);

        //服务器向客户端响应数据

        //1
        //响应一个JSON对象格式的字符串
        String person="{'education':'大学','zhuanye','computer'}";
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out=resp.getWriter();
        out.print(person);
        out.flush();
        out.close();

        //2
//        Map map=new HashMap();
//        map.put("edu","幼儿园");
//        map.put("zy","国语");
//        //将Map键值对转换成json对象
//        //创建JSON对象
//        JSONObject json=new JSONObject();
//        json.putAll(map);
//        json.put("family","五好");

//        PrintWriter out=resp.getWriter();
//        out.print(json.toString());
//        out.flush();
//        out.close();

        //3
//        User user1=new User("小白","女",18);
//        JSONObject json=JSONObject.fromObject(user1);
//
//        PrintWriter out=resp.getWriter();
//        out.print(json.toString());
//        out.flush();
//        out.close();

    }
}
