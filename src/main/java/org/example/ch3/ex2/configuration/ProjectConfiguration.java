package org.example.ch3.ex2.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {"org.example.ch3.ex2.proxies",
                "org.example.ch3.ex2.services",
                "org.example.ch3.ex2.repositories"}
)
public class ProjectConfiguration {
}
