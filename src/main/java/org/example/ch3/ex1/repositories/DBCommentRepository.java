package org.example.ch3.ex1.repositories;

import org.example.ch3.ex1.model.Comment;

public class DBCommentRepository implements CommentRepository{

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
