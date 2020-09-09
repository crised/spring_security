package com.example.mvc_basics.service;

import com.example.mvc_basics.mapper.MessageMapper;
import com.example.mvc_basics.model.ChatForm;
import com.example.mvc_basics.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public List<ChatMessage> getChatMessages() {
        return messageMapper.getMessages();
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessage(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessage(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessage(chatForm.getMessageText().toLowerCase());
                break;
        }
        this.messageMapper.insert(newMessage);
    }

}
