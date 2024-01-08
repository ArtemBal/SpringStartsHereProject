package org.example.ch4.ex1.main;


import org.example.ch4.ex1.condig.ProjectConfig;
import org.example.ch4.ex1.services.CommentService;
import org.example.ch4.ex1.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = c.getBean(CommentService.class);
        var cs2 = c.getBean(UserService.class);

        boolean b = cs1.getCommentRepository() == cs2.getCommentRepository();
        System.out.println(b);
    }
}
