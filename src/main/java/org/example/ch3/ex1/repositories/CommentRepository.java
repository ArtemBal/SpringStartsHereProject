package org.example.ch3.ex1.repositories;

import org.example.ch3.ex1.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
