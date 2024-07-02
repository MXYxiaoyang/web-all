package com.java.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * ClassName:Servlet1
 * Package:com.java.servlet
 * Description:
 *
 * @Author:XiaoYAng :2024/6/28 - 21:22
 * @Version:v1.8
 */
//注解方式配置Servlet
@WebServlet(urlPatterns = "/servlet2",
        initParams = {@WebInitParam(name = "keya", value = "valuea"),@WebInitParam(name = "keyb", value = "valueb")})
public class Servlet2 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        //获取初始配置信息
        //根据参数名获取参数值
        String keya = servletConfig.getInitParameter("keya");
        System.out.println("keya = "+keya);

        //获取所有参数名
        //hasMoreElements()  1.判断是否有下一个元素  2.如果有，返回true，否则false
        //nextElement()      1.返回下一个元素       2.向下移动游标
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();

        if (initParameterNames.hasMoreElements()) {
            String pname = initParameterNames.nextElement();

            System.out.println(pname+"="+getInitParameter(pname));
        }

        System.out.println("----------------------------------servletContext配置信息---------------------------------");
        //获取ServletContext对象的三种方式
        ServletContext servletContext = servletConfig.getServletContext();
        ServletContext servletContext1 = req.getServletContext();
        ServletContext servletContext2 = getServletContext();
        System.out.println(servletContext == servletContext1);
        System.out.println(servletContext1 == servletContext2);

        String encoding = servletContext.getInitParameter("encoding");
        System.out.println("encoding = "+encoding);

        Enumeration<String> ParameterNames = servletContext.getInitParameterNames();
        while (ParameterNames.hasMoreElements()) {
            String pname = ParameterNames.nextElement();
            System.out.println(pname+"="+servletContext.getInitParameter(pname));
        }


        //从域对象中读取数据
        Object name = (String)servletContext.getAttribute("name");
        System.out.println(name);
    }
}
