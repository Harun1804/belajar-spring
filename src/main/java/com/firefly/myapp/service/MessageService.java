package com.firefly.myapp.service;

import com.firefly.myapp.model.Messages;
import com.firefly.myapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Messages> findAllMessages() {
        List<Messages> messages = new ArrayList<>();
        messageRepository.findAll().forEach(messages::add);
        return messages;
    }

    public Messages findMessageById(int id) {
        Optional<Messages> optionalMessages = messageRepository.findById(id);
        return optionalMessages.orElse(null);
    }

    public void saveOrUpdate(Messages messages) {
        messageRepository.save(messages);
    }

    public void update(Messages messages, int id)
    {
        Messages message = findMessageById(id);
        if (message != null) {
            message.setId(id);
            message.setText(messages.getText());
            messageRepository.save(message);
        }
    }

    public void delete(int id)
    {
        messageRepository.deleteById(id);
    }
}
