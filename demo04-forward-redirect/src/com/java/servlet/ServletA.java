package com.java.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName:ServletA
 * Package:com.java.servlet
 * Description:
 *
 * @Author:XiaoYAng :2024/7/1 - 15:14
 * @Version:v1.8
 */

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    /**
     *1.请求转发是通过HttpServletRequest对象实现的
     * 2.请求转发是服务器内部行为，对客户端是屏蔽的
     * 3.客户端只产生了一次请求，服务端只产生了一对 request和response对象
     * 4.客户端的地址是不变的
     * 5.请求的参数是可以继续传递的
     * 6.目标资源可以是servlet动态资源，也可以是html静态资源
     * 7.目标资源可以是web——inf下的受保护的资源，该方式也是web-inf下的资源的唯一访问方式
     *
     * */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ServletA执行了");



        // 转发到ServletB
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("a.html");
        //让请求转发器做出转发动作
        requestDispatcher.forward(req, resp);

    }
}
