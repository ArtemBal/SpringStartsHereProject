package ch3.ex1;

import org.example.ch3.ex1.model.Comment;
import org.example.ch3.ex1.proxies.CommentNotificationProxy;
import org.example.ch3.ex1.repositories.CommentRepository;
import org.example.ch3.ex1.services.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AppTests {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private CommentNotificationProxy commentNotificationProxy;

    @InjectMocks
    private CommentService commentService;

    @Test
    @DisplayName("Verify that dependencies of the CommentService object are correctly called.")
    public void testCommentService() {
        var comment = new Comment();

        commentService.publishComment(comment);

        verify(commentRepository).storeComment(comment);
        verify(commentNotificationProxy).sendComment(comment);
    }
}
