package com.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ServletB
 * Package:com.java.servlet
 * Description:
 *
 * @Author:XiaoYAng :2024/7/14 - 7:31
 * @Version:v1.8
 */
@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求中携带的cookie
        Cookie[] cookies = req.getCookies();
        //请求中的多个cookie会进入该数组  请求中如果没有cookie，则该数组为null
        if(null!= cookies){
            for (Cookie cookie : cookies){
            System.out.println(cookie.getName() + "="+cookie.getValue());
        }}


    }
}
