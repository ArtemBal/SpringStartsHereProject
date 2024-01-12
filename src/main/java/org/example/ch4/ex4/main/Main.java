package org.example.ch4.ex4.main;


import org.example.ch4.ex4.condig.ProjectConfig;
import org.example.ch4.ex4.services.CommentService;
import org.example.ch4.ex4.services.UserService;
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
