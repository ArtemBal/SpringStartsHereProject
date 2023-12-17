package org.example.ch1.ex1;

import org.example.ch1.ex1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean("koko", Parrot.class);
        System.out.println(p.getName());


    }
}
