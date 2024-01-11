package org.example.ch4.ex2.main;


import org.example.ch4.ex2.condig.ProjectConfig;
import org.example.ch4.ex2.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("Before retrieving the CommentService");
        var service = c.getBean(CommentService.class);
        System.out.println("After retrieving the CommentService");
    }
}

