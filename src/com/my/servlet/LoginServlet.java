package com.my.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2017/6/19.
 */
@WebServlet("/login")
public class LoginServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        java.sql.Statement stmt = null;
        ResultSet rs = null;

        //获得相应的out对象
        PrintWriter out = resp.getWriter();
        //设置请求的编码
        req.setCharacterEncoding("UTF-8");

        //获取客户端提交的数据
        String username = req.getParameter("name");
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获得链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practicedb", "root", "123456");
//            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/practicedb?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8 ","root","123456");
            //获得状态集
            stmt = conn.createStatement();
            //获得结果集
            rs = stmt.executeQuery(String.format("SELECT * FROM `practicedb`.`user_login` WHERE username='%s'", username));
            if (rs.next()) {
                out.println(1);
            } else {
                out.println(0);
            }
        } catch (Exception e) {
            out.println(0);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
