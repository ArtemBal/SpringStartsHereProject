package org.example.ch4.ex1.condig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.ch4.ex1.repositories, org.example.ch4.ex1.services"})
public class ProjectConfig {
}
