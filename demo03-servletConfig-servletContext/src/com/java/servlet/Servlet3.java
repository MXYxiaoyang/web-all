package com.java.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName:Servlet3
 * Package:com.java.servlet
 * Description:
 *
 * @Author:XiaoYAng :2024/7/1 - 8:50
 * @Version:v1.8
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        //向upload目录中写入一个文件
        //获得一个指向项目步数位置下的某个文件/目录的磁盘真实路径的API
        String path = servletContext.getRealPath("upload/Ma.txt");
        System.out.println("path:" + path);

        //获取项目部署的上下文路径  项目的访问路径
        //后续我们会学习在项目使用相对和绝对路径找目标资源
        // servlet1             /demo3/servlet1
        //获取项目的上下文路径   项目的访问路径
        String contextPath = servletContext.getContextPath();
        System.out.println("contextPath:" + contextPath);




    }
}
