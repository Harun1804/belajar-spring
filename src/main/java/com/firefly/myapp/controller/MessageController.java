package com.firefly.myapp.controller;

import com.firefly.myapp.model.Messages;
import com.firefly.myapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping
    private List<Messages> index() {
        return messageService.findAllMessages();
    }

    @GetMapping("/{id}")
    private Messages show(@PathVariable("id") int id) {
        return messageService.findMessageById(id);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") int id) {
        messageService.delete(id);
    }

    @PostMapping
    private int store(@RequestBody Messages messages)
    {
        messageService.saveOrUpdate(messages);
        return messages.getId();
    }

    @PutMapping("/{id}")
    private int update(@RequestBody Messages messages, @PathVariable("id") int id)
    {
        messageService.update(messages, id);
        return messages.getId();
    }
}
