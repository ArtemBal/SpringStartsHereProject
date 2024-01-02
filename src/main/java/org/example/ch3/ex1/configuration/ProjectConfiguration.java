package org.example.ch3.ex1.configuration;

import org.example.ch3.ex1.proxies.CommentNotificationProxy;
import org.example.ch3.ex1.proxies.EmailCommentNotificationProxy;
import org.example.ch3.ex1.repositories.CommentRepository;
import org.example.ch3.ex1.repositories.DBCommentRepository;
import org.example.ch3.ex1.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Bean
    public CommentRepository commentRepository() {
        return new DBCommentRepository();
    }

    @Bean
    public CommentNotificationProxy commentNotificationProxy() {
        return new EmailCommentNotificationProxy();
    }

    @Bean
    public CommentService commentService(CommentRepository commentRepository,
                                         CommentNotificationProxy commentNotificationProxy) {
        return new CommentService(commentRepository, commentNotificationProxy);
    }
}
