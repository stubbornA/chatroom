package com.lyf.service;

import com.lyf.vo.ChatContent;
import com.lyf.vo.ChatRoom;

import java.util.List;

/**
 * Created by fangjiejie on 2017/11/17.
 */
public interface IChatService {
    List<ChatRoom> queryAllChatRoom();
    List<ChatContent> queryAllContentByTid(int id);//根据房间查询所有言论
    boolean addContent(ChatContent chatContent);
    List<String> queryUsersByTid(int id);
}
