package org.example.ch3.ex2.proxies;

import org.example.ch3.ex2.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentPushNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment: " + comment.getText());
    }
}
