package ch5.ex2;

import org.example.ch5.ex2.aspects.LoggingAfterReturningAspect;
import org.example.ch5.ex2.aspects.LoggingAspect;
import org.example.ch5.ex2.config.ProjectConfig;
import org.example.ch5.ex2.models.Comment;
import org.example.ch5.ex2.services.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.logging.Logger;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    private Logger serviceLogger;
    private Logger aspectLogger;
    private Logger afterReturningLogger;

    @Autowired
    private LoggingAspect loggingAspect;

    @Autowired
    private LoggingAfterReturningAspect loggingAfterReturningAspect;

    @Autowired
    private CommentService commentService;

    @BeforeEach
    public void before() {
        this.aspectLogger = mock(Logger.class);
        loggingAspect.setLogger(aspectLogger);

        this.serviceLogger = mock(Logger.class);
        commentService.setLogger(serviceLogger);

        this.afterReturningLogger = mock(Logger.class);
        loggingAfterReturningAspect.setLogger(afterReturningLogger);
    }

    @Test
    @DisplayName("Aspect interrupts delete method")
    public void aspectInterruptsDelete() {
        Comment comment = new Comment();
        comment.setText("Test comment text");
        comment.setAuthor("Test comment author");

        commentService.deleteComment(comment);

        verify(serviceLogger).info("Deleting comment:" + comment.getText());
        verify(aspectLogger, atLeastOnce()).info("Method deleteComment with parameters [" + comment + "] will execute");
        verify(aspectLogger, atLeastOnce()).info("Method executed and returned null");
    }

    @Test
    @DisplayName("Aspect doesn't interrupts publish method")
    public void aspectDoesntInterruptsPublish() {
        Comment comment = new Comment();
        comment.setText("Test comment text");
        comment.setAuthor("Test comment author");

        commentService.publishComment(comment);

        verify(serviceLogger).info("Publishing comment:" + comment.getText());
        verify(aspectLogger, never()).info("Method publishComment with parameters [" + comment + "] will execute");
        verify(aspectLogger, never()).info("Method executed and returned null");
    }

    @Test
    @DisplayName("Aspect doesn't interrupts edit method")
    public void aspectDoesntInterruptsEdit() {
        Comment comment = new Comment();
        comment.setText("Test comment text");
        comment.setAuthor("Test comment author");

        commentService.editComment(comment);

        verify(serviceLogger).info("Editing comment:" + comment.getText());
        verify(aspectLogger, never()).info("Method editComment with parameters [" + comment + "] will execute");
        verify(aspectLogger, never()).info("Method executed and returned null");
    }

    @Test
    @DisplayName("Aspect after edit method")
    public void aspectAfterEdit() {
        Comment comment = new Comment();
        comment.setText("Test comment text");
        comment.setAuthor("Test comment author");

        commentService.editComment(comment);

        verify(serviceLogger).info("Editing comment:" + comment.getText());
        verify(aspectLogger, never()).info("Method editComment with parameters [" + comment + "] will execute");
        verify(aspectLogger, never()).info("Method executed and returned null");
        verify(afterReturningLogger, atLeastOnce()).info("After returning advice: Processing the result - " + comment.getText());
    }
}
