package org.example.ch3.ex1.services;

import org.example.ch3.ex1.model.Comment;
import org.example.ch3.ex1.proxies.CommentNotificationProxy;
import org.example.ch3.ex1.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
