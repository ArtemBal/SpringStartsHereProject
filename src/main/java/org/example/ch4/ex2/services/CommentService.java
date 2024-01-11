package org.example.ch4.ex2.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class CommentService {

    public CommentService() {
        System.out.println("CommentService instance created!");
    }
}
