package com.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName:Servlet6
 * Package:com.java.servlet
 * Description:
 *
 * @Author:XiaoYAng :2024/7/1 - 10:28
 * @Version:v1.8
 */
@WebServlet("/servlet6")
public class Servlet6 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应行相关的API  HTTP/1.1 200/404/405/500/...
        resp.setStatus(200);
        //设置响应头相关的API
        //resp.setHeader("aaa", "valuea");
        //resp.setHeader("Content-Type", "text/html");
        //resp.setContentType("text/html");
        //resp.setContentLength(124);
        String info = "<h1>hello world</h1>";
        resp.setContentType("text/html");
        resp.setContentLength(info.getBytes().length);

        //设置响应体内容API
        PrintWriter writer = resp.getWriter();
        writer.write(info);
    }
}
