package com.example.mvc_basics.mapper;

import com.example.mvc_basics.model.ChatMessage;
import com.example.mvc_basics.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES")
    ChatMessage[] getMessages();

    @Insert("INSERT INTO MESSAGES (username, message)" +
            "VALUES(#{username}, #{message})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(User user);
}
