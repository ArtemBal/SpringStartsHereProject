package org.example.ch4.ex5.condig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "org.example.ch4.ex5.repositories, " +
        "org.example.ch4.ex5.services, " +
        "org.example.ch4.ex5.processors"})
public class ProjectConfig {
}
