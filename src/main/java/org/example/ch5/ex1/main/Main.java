package org.example.ch5.ex1.main;

import org.example.ch5.ex1.config.ProjectConfig;
import org.example.ch5.ex1.models.Comment;
import org.example.ch5.ex1.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");

        service.publishComment(comment);
    }
}
