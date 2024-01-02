package org.example.ch3.ex2.main;

import org.example.ch3.ex2.configuration.ProjectConfiguration;
import org.example.ch3.ex2.model.Comment;
import org.example.ch3.ex2.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var comment = new Comment();
        comment.setAuthor("Laurentiu");
        comment.setText("Demo comment");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}

