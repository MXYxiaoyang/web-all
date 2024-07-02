package com.java.serlvet;

/**
 * ClassName:ServletLifeCycle
 * Package:com.java.serlvet
 * Description:
 *
 * @Author:XiaoYAng :2024/6/28 - 20:00
 * @Version:v1.8
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/***
 *
 * servlet生命周期
 * 1.实例化                        构造器           第一次请求
 * 2.初始化                       init()方法       构造完毕
 * 3.接收请求，处理请求，服务   service()方法         每次请求
 * 4.销毁                       destroy()方法       关闭服务器
 *
 * servlet再tomcat中是单例的
 * servlet的成员变量在多个线程栈之中是共享的
 * 不建议在servlet 方法中修改成员变量 在并发请求时，会引发线程安全问题
 *
 * servlet继承结构
 * 1.顶级的servlet接口
 * public interface Servlet {
 *
 *      //初始化方法，由tomcat自动调用完成初始化功能的方法
 *     void init(ServletConfig var1) throws ServletException;
 *
 *       //获得ServletConfig对象，用于获取初始化参数
 *     ServletConfig getServletConfig();
 *
 *     //接收用户请求，处理请求
 *     void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 *
 *     //返回servlet字符串形式描述信息的方法
 *     String getServletInfo();
 *
 *      //销毁方法，由tomcat自动调用完成销毁功能的方法，由于做了一些资源释放的操作，所以需要重写该方法
 *     void destroy();
 * }
 *
 *
 *
 *   2.抽象的类     GenericServlet      侧重除了service方法以外的其他方法的基础处理
 *   public abstract class GenericServlet implements Servlet{
 *    private transient ServletConfig config;
 *        public void destroy() {
 *        //将抽象方法，重写为普通方法，在方法内部没有任何的实现代码
 *      //平庸实现
 *     }
 *     //tomcat在调用init方法时，会读取配置信息进入一个servletConfig对象并将该对象传入init方法中
 *         public void init(ServletConfig config) throws ServletException {
 *         //将ServletConfig对象保存到成员变量中
 *         this.config = config;
 *         this.init();
 *     }
 *            //重载的初始化方法，我们要重写初始化方法时对应的方法
 *         public void init() throws ServletException {
 *     }
 *         //返回servletConfig的方法
 *         public ServletConfig getServletConfig() {
 *         return this.config;
 *     }
 *
 *     //再次抽象声明service方法
 *         public abstract void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;
 *
 *   }
 *
 *
 *   3.HttpServlet  抽象类，侧重service方法的处理·
 *   public abstract class HttpServlet extends GenericServlet {
 *               //参数的父转子，调用重载的service方法
 *            public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
 *            //强制转型，参数的父转子
 *              HttpServletRequest request = (HttpServletRequest)req;
 *              HttpServletResponse response = (HttpServletResponse)res;
 *              //调用重载的service方法
 *         this.service(request, response);
 *     }
 *
 *     protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *     //获取请求的方法
 *         String method = req.getMethod();    //GET/POST/PUT/DELETE/HEAD/OPTIONS/TRACE...
 *         if (method.equals("GET")) {
 *             this.doGet(req, resp);
 *         } else if (method.equals("HEAD")) {
 *             this.doHead(req, resp);
 *         } else if (method.equals("POST")) {
 *             this.doPost(req, resp);
 *         } else if (method.equals("PUT")) {
 *             this.doPut(req, resp);
 *         } else if (method.equals("DELETE")) {
 *             this.doDelete(req, resp);
 *         } else if (method.equals("OPTIONS")) {
 *             this.doOptions(req, resp);
 *         } else if (method.equals("TRACE")) {
 *             this.doTrace(req, resp);
 *         } else {
 *             String errMsg = lStrings.getString("http.method_not_implemented");
 *             Object[] errArgs = new Object[]{method};
 *             errMsg = MessageFormat.format(errMsg, errArgs);
 *             resp.sendError(501, errMsg);
 *         }
 *             protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *                                   "http.method_get_not_supported"
 *            //故意响应405 请i去方法不允许的信息
 *             resp.sendError(405, msg);
 *     }
 *                   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *                                   "http.method_get_not_supported"
 *             //故意响应405 请i去方法不允许的信息
 *               resp.sendError(405, msg);
 *      }
 *     }
 *
 *  }
 *
 *  4. 自定义servlet
 *  class servlet1 extends HttpServlet{
 *        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 *            //接收用户请求信息
 *
 *
 *            //做出响应
 *        }
 *  }
 *
 *
 *   1.部分程序员推荐在servlet中重写do***方法处理请求，理由：service方法中可能做了一些处理，如果我们直接重写service的话，父类中国service方法处理的功能则失效
 *   2.目前直接重写service也没有什么问题
 *   3.后续使用了SpringMVC框架后，我们则无需继承HttpServlet，而是继承SpringMVC框架提供的接口，并实现相关方法即可
 *   4.如果doGet和doPost方法中，我们定义的代码都一样，可以让一个方法直接调用另一个方法
 *
 *
 *   掌握的技能：
 *      继承HttpServlet，要么重写service方法，要么重写   doGet/doPost方法
 *
 *
 *
 *
 *
 */


@WebServlet(value="/ServletLifeCycle",loadOnStartup=-1)
public class ServletLifeCycle  extends HttpServlet {

  public ServletLifeCycle(){
        System.out.println("构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("服务");
//    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                           //故意响应405 请i去方法不允许的信息
        System.out.println("get请求处理方法");
     }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //故意响应405 请i去方法不允许的信息
        System.out.println("post请求处理方法");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
