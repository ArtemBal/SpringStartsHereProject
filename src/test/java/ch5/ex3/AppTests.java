package ch5.ex3;

import org.example.ch5.ex3.aspects.LoggingAspect;
import org.example.ch5.ex3.aspects.SecurityAspect;
import org.example.ch5.ex3.config.ProjectConfig;
import org.example.ch5.ex3.models.Comment;
import org.example.ch5.ex3.services.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTests {

    private Logger serviceLogger;
    private Logger loggingAspectLogger;
    private Logger securityAspectLogger;

    @Autowired
    private LoggingAspect loggingAspect;

    @Autowired
    private SecurityAspect securityAspect;

    @Autowired
    private CommentService commentService;

    @BeforeEach
    public void before() {
        this.loggingAspectLogger = mock(Logger.class);
        loggingAspect.setLogger(loggingAspectLogger);

        this.securityAspectLogger = mock(Logger.class);
        securityAspect.setLogger(securityAspectLogger);

        this.serviceLogger = mock(Logger.class);
        commentService.setLogger(serviceLogger);
    }

    @Test
    @DisplayName("Test that both aspects intercept the execution" +
            " of the publishComment() method.")
    public void testAspectInterceptsPublishCommentMethod() {
        Comment comment = new Comment();
        comment.setText("Test comment text");
        comment.setAuthor("Test comment author");

        commentService.publishComment(comment);

        verify(serviceLogger).info("Publishing comment:" + comment.getText());
        verify(securityAspectLogger).info("Security Aspect: Calling the intercepted method");
        verify(loggingAspectLogger).info("Logging Aspect: Calling the intercepted method");
    }

}
