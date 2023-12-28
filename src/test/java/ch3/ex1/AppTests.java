package ch3.ex1;

import org.example.ch3.ex1.model.Comment;
import org.example.ch3.ex1.proxies.CommentNotificationProxy;
import org.example.ch3.ex1.repositories.CommentRepository;
import org.example.ch3.ex1.services.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AppTests {         // TODO: Mock tests doesn't work with 17 version of java but works fine with 11

    @Test
    @DisplayName("Verify that CommentService correctly delegates the " +
            "responsibilities to the repository and proxy objects.")
    public void testCommentService() {
        var comment = mock(Comment.class);
        var commentRepository = mock(CommentRepository.class);
        var commentNotificationService = mock(CommentNotificationProxy.class);

        var commentService = new CommentService(commentRepository, commentNotificationService);

        commentService.publishComment(comment);

        verify(commentRepository).storeComment(comment);
        verify(commentNotificationService).sendComment(comment);
    }
}
