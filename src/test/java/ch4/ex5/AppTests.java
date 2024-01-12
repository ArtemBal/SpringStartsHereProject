package ch4.ex5;

import org.example.ch4.ex5.condig.ProjectConfig;
import org.example.ch4.ex5.models.Comment;
import org.example.ch4.ex5.repositories.CommentRepository;
import org.example.ch4.ex5.services.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    @Autowired
    private ApplicationContext context;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Verify that CommentRepository every time you request an instance" +
            " from the Spring context, you get a new instance")
    public void testCommentRepositoryIsPrototype() {
        var cr1 = context.getBean("commentRepository", CommentRepository.class);
        var cr2 = context.getBean("commentRepository", CommentRepository.class);

        assertNotEquals(cr1, cr2);
    }

    @Test
    @DisplayName("Verify that CommentService use new instance of CommentProcessor every time")
    public void testCommentServiceUseNewCommentProcessor() {
        try {
            setUpStreams();
            ApplicationContext testContext =
                    new AnnotationConfigApplicationContext(ProjectConfig.class);

            var commentService = testContext.getBean(CommentService.class);

            commentService.sendComment(new Comment());
            commentService.sendComment(new Comment());
            assertEquals("New CommentProcessor!\nNew CommentProcessor!\n", outContent.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            restoreStreams();
        }
    }
}
