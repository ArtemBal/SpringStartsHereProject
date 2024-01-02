package org.example.ch3.ex2.repositories;

import org.example.ch3.ex2.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
