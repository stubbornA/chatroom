package com.lyf.service;

import com.lyf.dao.ChatDaoImp;
import com.lyf.vo.ChatContent;
import com.lyf.vo.ChatRoom;

import java.util.List;

/**
 * Created by fangjiejie on 2017/11/17.
 */
public class ChatServiceImp implements IChatService {
    ChatDaoImp chatDaoImp=null;

    public ChatServiceImp() {
        chatDaoImp=new ChatDaoImp();
    }

    @Override
    public List<ChatRoom> queryAllChatRoom() {
        return chatDaoImp.queryAllChatRoom();
    }

    @Override
    public List<ChatContent> queryAllContentByTid(int id) {
        return chatDaoImp.queryAllContentByTid(id);
    }

    @Override
    public List<String> queryUsersByTid(int id) {
        return chatDaoImp.queryUsersByTid(id);
    }

    @Override
    public boolean addContent(ChatContent chatContent) {
        return chatDaoImp.addContent(chatContent);
    }
}
