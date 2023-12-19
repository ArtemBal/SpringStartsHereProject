package org.example.ch1.ex3;

import org.example.ch1.ex3.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p1 = new Parrot();
        p1.setName("Kiki");

        Supplier<Parrot> parrotSupplier = () -> p1;

        context.registerBean("p1", Parrot.class, parrotSupplier);

        Parrot p2 = context.getBean(Parrot.class);
        System.out.println(p2.getName());
    }
}
