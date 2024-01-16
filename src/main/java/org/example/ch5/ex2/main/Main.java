package org.example.ch5.ex2.main;

import org.example.ch5.ex2.config.ProjectConfig;
import org.example.ch5.ex2.models.Comment;
import org.example.ch5.ex2.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");

        service.publishComment(comment);
        service.deleteComment(comment);
        service.editComment(comment);
    }
}
