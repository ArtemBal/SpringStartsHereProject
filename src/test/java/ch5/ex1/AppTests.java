package ch5.ex1;

import org.example.ch5.ex1.config.ProjectConfig;
import org.example.ch5.ex1.models.Comment;
import org.example.ch5.ex1.services.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTests {

    @Autowired
    private CommentService commentService;

    @Test
    @DisplayName("Test that the aspect intercepts and alters the returned value" +
            " of the publishComment() method.")
    public void testAspectInterceptsPublishCommentMethod() {
        Comment comment = new Comment();
        comment.setText("Test comment text");
        comment.setAuthor("Test comment author");

        String result = commentService.publishComment(comment);

        assertEquals("FAILED", result);
    }
}
