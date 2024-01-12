package org.example.ch4.ex5.main;


import org.example.ch4.ex5.condig.ProjectConfig;
import org.example.ch4.ex5.models.Comment;
import org.example.ch4.ex5.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var commentService = c.getBean(CommentService.class);

        commentService.sendComment(new Comment());
        commentService.sendComment(new Comment());
    }
}
