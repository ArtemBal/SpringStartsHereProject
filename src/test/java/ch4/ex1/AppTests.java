package ch4.ex1;

import org.example.ch4.ex1.condig.ProjectConfig;
import org.example.ch4.ex1.services.CommentService;
import org.example.ch4.ex1.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Every CommentRepository Spring context uses is same instance")
    public void testCommentServiceIsSingleton() {
        var cs1 = context.getBean(CommentService.class);
        var cs2 = context.getBean(UserService.class);

        assertEquals(cs1.getCommentRepository(), cs2.getCommentRepository());

    }
}
