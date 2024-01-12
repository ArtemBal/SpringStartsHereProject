package org.example.ch4.ex3.main;


import org.example.ch4.ex3.condig.ProjectConfig;
import org.example.ch4.ex3.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = c.getBean("commentService", CommentService.class);
        var cs2 = c.getBean("commentService", CommentService.class);

        boolean b1 = cs1 == cs2;

        System.out.println(b1);

    }
}

