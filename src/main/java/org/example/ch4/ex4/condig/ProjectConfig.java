package org.example.ch4.ex4.condig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.ch4.ex4.repositories, org.example.ch4.ex4.services"})
public class ProjectConfig {
}
