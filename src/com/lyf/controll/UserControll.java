package com.lyf.controll;

import com.lyf.service.UserServiceImp;
import com.lyf.vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fangjiejie on 2017/11/17.
 */
@WebServlet(
        name="userControll",
        urlPatterns = {"/user"},
        initParams = {@WebInitParam(name="index",value = "/index.jsp"),
        @WebInitParam(name="show",value = "/show.jsp")}
)
public class UserControll extends HttpServlet{
    Map<String,String> pageMap=new HashMap<String,String>();
    UserServiceImp userService=new UserServiceImp();
    public UserControll() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        pageMap.put("index",config.getInitParameter("index"));
        pageMap.put("show",config.getInitParameter("show"));
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        switch (action){
            case "register":{
                register(req,resp);
                break;
            }
            case "login":{
                login(req,resp);
                break;
            }
            case "out":{
                out(req,resp);
                break;
            }
        }
    }

    private void out(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        RequestDispatcher rd=req.getRequestDispatcher(pageMap.get("index").toString());
        rd.forward(req,resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        User curUser=userService.login(user);
        if(curUser!=null){
            req.getSession().setAttribute("user",curUser);
            req.setAttribute("msg","登陆成功！");
        }else{
            req.setAttribute("msg","登录失败!");
            PrintWriter out=resp.getWriter();
            out.println("登录失败！");
        }
        RequestDispatcher rd=req.getRequestDispatcher(pageMap.get("index").toString());
        rd.forward(req,resp);
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        if(userService.register(user)){
            req.setAttribute("msg","注册成功！");
        }else{
            req.setAttribute("msg","注册失败!");
        }
        RequestDispatcher rd=req.getRequestDispatcher(pageMap.get("show").toString());
        rd.forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
