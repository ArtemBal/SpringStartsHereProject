package ch4.ex2;

import org.example.ch4.ex2.condig.ProjectConfig;
import org.example.ch4.ex2.services.CommentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
public class AppTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Verify that CommentService is not created")
    public void testCommentServiceIsNotCreated() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        assertEquals("", outContent.toString());
    }

    @Test
    @DisplayName("Verify that CommentService created")
    public void testCommentServiceIsCreated() {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = context.getBean(CommentService.class);
        assertEquals("CommentService instance created!\n", outContent.toString());
    }

}
