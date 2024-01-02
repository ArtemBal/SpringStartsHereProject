package org.example.ch3.ex2.proxies;

import org.example.ch3.ex2.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
