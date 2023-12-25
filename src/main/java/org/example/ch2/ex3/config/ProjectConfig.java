package org.example.ch2.ex3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.ch2.ex3.beans")
public class ProjectConfig {
}
