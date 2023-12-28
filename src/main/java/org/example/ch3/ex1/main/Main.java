package org.example.ch3.ex1.main;

import org.example.ch3.ex1.model.Comment;
import org.example.ch3.ex1.proxies.EmailCommentNotificationProxy;
import org.example.ch3.ex1.repositories.DBCommentRepository;
import org.example.ch3.ex1.services.CommentService;

public class Main {
    public static void main(String[] args) {
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();

        var commentService = new CommentService(commentRepository,
                commentNotificationProxy);

        var comment = new Comment();
        comment.setAuthor("Laurentiu");
        comment.setText("Demo comment");

        commentService.publishComment(comment);
    }
}
