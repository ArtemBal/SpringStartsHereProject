package org.example.ch3.ex1.proxies;

import org.example.ch3.ex1.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
