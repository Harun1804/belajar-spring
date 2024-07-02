package com.firefly.myapp.repository;

import com.firefly.myapp.model.Messages;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Messages, Integer> {
}
