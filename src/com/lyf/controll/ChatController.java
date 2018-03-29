package com.lyf.controll;

import com.lyf.service.ChatServiceImp;
import com.lyf.vo.ChatContent;
import com.lyf.vo.ChatRoom;
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
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fangjiejie on 2017/11/17.
 */
@WebServlet(
        name="chatControll",
        urlPatterns = {"/chat"},
        initParams = {
                @WebInitParam(name="index",value = "/index.jsp"),
                @WebInitParam(name="show",value = "/show.jsp"),
                @WebInitParam(name="chooseRoom",value = "/chooseRoom.jsp"),
                @WebInitParam(name="room",value = "/room.jsp")
        }
)
public class ChatController extends HttpServlet{
    Map pageMap=new HashMap<>();
    ChatServiceImp chatService=new ChatServiceImp();
    public ChatController() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        pageMap.put("index",config.getInitParameter("index"));
        pageMap.put("show",config.getInitParameter("show"));
        pageMap.put("chooseRoom",config.getInitParameter("chooseRoom"));
        pageMap.put("room",config.getInitParameter("room"));
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String action=req.getParameter("action");
        switch (action){
            case "queryAllChatRoom":{
                queryAllChatRoom(req,resp);
                break;
            }
            case "enterRoomById":{
                enterRoomById(req,resp);
                break;
            }
            case "addContent":{
                addContent(req,resp);
                break;
            }
        }
    }

    private void addContent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=(User)req.getSession().getAttribute("user");
        String roomid=req.getParameter("roomid").toString();
        String content=req.getParameter("content").toString();
        ChatContent chatContent=new ChatContent();
        chatContent.setTid(Integer.parseInt(roomid));
        chatContent.setContent(content);
        chatContent.setUid(user.getId());
        chatContent.setUname(user.getUsername());
        chatContent.setDate(new Timestamp(System.currentTimeMillis()));
        if(chatService.addContent(chatContent)){enterRoomById(req,resp);}
    }

    private void enterRoomById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=(User)req.getSession().getAttribute("user");
        String roomid=req.getParameter("roomid").toString();
//        String roomname=req.getParameter("roomname").toString();
        List<ChatContent> contentlist=chatService.queryAllContentByTid(Integer.parseInt(roomid));
        List<String> userlist=chatService.queryUsersByTid(Integer.parseInt(roomid));
        req.setAttribute("contentlist",contentlist);
        req.setAttribute("roomid",roomid);
        req.setAttribute("userlist",userlist);
//        req.setAttribute("roomname",roomname);
        RequestDispatcher rd=req.getRequestDispatcher(pageMap.get("room").toString());
        rd.forward(req,resp);
//        List<User> userlist=chatService.
    }

    private void queryAllChatRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ChatRoom> list=chatService.queryAllChatRoom();
        req.setAttribute("roomlist",list);
        RequestDispatcher rd=req.getRequestDispatcher(pageMap.get("chooseRoom").toString());
        rd.forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
