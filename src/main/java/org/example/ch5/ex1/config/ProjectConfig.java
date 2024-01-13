package org.example.ch5.ex1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.example.ch5.ex1.services, org.example.ch5.ex1.aspects")
@EnableAspectJAutoProxy
public class ProjectConfig {
}
