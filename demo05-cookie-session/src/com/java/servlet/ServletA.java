package com.java.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ServletA
 * Package:com.java.servlet
 * Description:
 *
 * @Author:XiaoYAng :2024/7/14 - 7:30
 * @Version:v1.8
 */

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie1 = new Cookie("keya", "valuea");
        //设置cookie的有效期
        cookie1.setMaxAge(60 * 60 * 24); //设置cookie有效期为1天,单位为秒
        //设置cookie的路径
        cookie1.setPath("/demo05/ServletB");

        Cookie cookie2 = new Cookie("keyb", "valueb");

        //将cookie放入response对象
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
