package com.example.mvc_basics.mapper;

import com.example.mvc_basics.model.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES")
    @Results(
            {@Result(property = "message", column = "messagetext")
    })
    List<ChatMessage> getMessages();

    @Insert("INSERT INTO MESSAGES (username, messagetext)" +
            "VALUES(#{username}, #{message})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(ChatMessage message);
}
