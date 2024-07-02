package com.java.serlvet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName:UserServlet
 * Package:com.java.serlvet
 * Description:
 *
 * @Author:XiaoYAng :2024/6/27 - 20:25
 * @Version:v1.8
 */
/**
 * servlet开发流程：
 * 1.创建javaweb项目，同时将tomcat添加为当前的项目的依赖
 * 2.重写service方法，service(HttpServletRequest req, HttpServletResponse resp)
 * 3.在service方法中，定义业务处理代码
 *4.在web.xml中，配置servlet对应的请求映射路径
 *
 *
 * 1.servlet-api.jar导入问题
 *      servlet-api 编码的时候需要，运行的时候，在服务器的环境中，有服务软件（tomcat）提供
 * 2.Content-type响应头的问题、
 *      MIME类型响应头  媒体类型，文件类型，相应的数据类型
 *      MIME类型用于告诉客户相应的数据是什么类型的数据，客户端以此类型决定用什么方式解析响应体
 * */
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.从request对象中获取请求中的任何信息
        String username = request.getParameter("username");
        //2.处理业务的代码
        String info = "yes";
        if("atguigu".equals(username)){
            info="no";
        }
        //3.将要响应的数据放入response
        PrintWriter writer = response.getWriter();   //改方法返回的是一个向响应体中打印的字符串的打印流
        writer.write(info);
    }
}


















