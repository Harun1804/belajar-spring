package com.firefly.myapp.controller;

import com.firefly.myapp.model.Messages;
import com.firefly.myapp.service.MessageService;
import com.firefly.myapp.utils.ResponseFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping
    private ResponseFormatter<List<Messages>> index() {
        List<Messages> messages = messageService.findAllMessages();
        return new ResponseFormatter<>(true, "Get all messages", messages);
    }

    @GetMapping("/{id}")
    private ResponseFormatter<Messages> show(@PathVariable("id") int id) {
        Messages message = messageService.findMessageById(id);
        if (message != null) {
            return new ResponseFormatter<>(message);
        } else{
            return new ResponseFormatter<>(false, "Message Not Found");
        }
    }

    @PostMapping
    private ResponseFormatter<Void> store(@RequestBody Messages messages)
    {
        messageService.saveOrUpdate(messages);
        return new ResponseFormatter<>(true, "Message Has Been Created");
    }

    @PutMapping("/{id}")
    private ResponseFormatter<Void> update(@RequestBody Messages messages, @PathVariable("id") int id)
    {
        Messages message = messageService.findMessageById(id);
        if (message != null) {
            messageService.update(messages, id);
            return new ResponseFormatter<>(true, "Message Has Been Updated");
        } else {
            return new ResponseFormatter<>(false, "Message Not Found");
        }
    }

    @DeleteMapping("/{id}")
    private ResponseFormatter<Void> delete(@PathVariable("id") int id) {
        Messages message = messageService.findMessageById(id);
        if (message != null) {
            messageService.delete(id);
            return new ResponseFormatter<>(true, "Message Has Been Deleted");
        } else {
            return new ResponseFormatter<>(false, "Message Not Found");
        }
    }
}
