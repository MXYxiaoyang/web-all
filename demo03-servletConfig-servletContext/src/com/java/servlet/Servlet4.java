package com.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * ClassName:Servlet4
 * Package:com.java.servlet
 * Description:
 *
 * @Author:XiaoYAng :2024/7/1 - 9:39
 * @Version:v1.8
 */
@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //行相关  GET/POST    uri          http/1.1
        System.out.println(req.getMethod());   //获取请求方式
        System.out.println(req.getScheme());    //获取请求协议
        System.out.println(req.getProtocol());   //获取请求协议版本
        System.out.println(req.getRequestURI());  //获取请求的URI     项目内的资源路径
        System.out.println(req.getRequestURL());  //获取请求的URL     项目内资源的完成的路径

        /**
         * URI  统一资源标识符 /demo03/Servlet4       interface URI {}                资源定位的要求和规范        动物类
         * URL  统一资源定位符    http://ip:port/demo03/Servlet4    class URL implements URI {}     一个具体的资源路径          哺乳动物类
         * */

        System.out.println(req.getLocalPort());//本应用容器的端口号
        System.out.println(req.getRemotePort()); //客户端软件的端口号
        System.out.println(req.getServerPort()); //客户端发请求时使用的端口号

        //头相关
        //根据名字单独获取某个请求头
        String accept = req.getHeader("Accept");
        System.out.println("accept"+accept);

        //获取本次请求中所有的请求头的名字
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String hname = headerNames.nextElement();
            System.out.println(hname + ":" + req.getHeader(hname));
        }


    }
}
