package org.example.ch3.ex1.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "org.example.ch3.ex1.proxies",
        "org.example.ch3.ex1.repositories",
        "org.example.ch3.ex1.services"})
public class ProjectConfiguration {
}
