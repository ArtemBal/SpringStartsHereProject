package org.example.ch5.ex2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.example.ch5.ex2.services, org.example.ch5.ex2.aspects")
@EnableAspectJAutoProxy
public class ProjectConfig {
}
