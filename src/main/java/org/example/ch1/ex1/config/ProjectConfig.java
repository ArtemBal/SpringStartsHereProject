package org.example.ch1.ex1.config;

import org.example.ch1.ex1.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean("koko")
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean(name = "miki")
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Miki");
        return p;
    }

    @Bean
    Parrot parrot3() {
        var p = new Parrot();
        p.setName("Riki");
        return p;
    }

    @Bean(value = "kiki")
    Parrot parrot4() {
        var p = new Parrot();
        p.setName("Kiki");
        return p;
    }
}