package ch1.ex2;

import org.example.ch1.ex2.Parrot;
import org.example.ch1.ex2.config.ProjectConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProjectConfig.class})
public class AppTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test that new spring bean has name null")
    public void beanNameIsNull() {
        Parrot p = context.getBean(Parrot.class);

        assertNotNull(p);
        assertNull(p.getName());
    }

    @Test
    @DisplayName("Test  that bean name is changed")
    public void beanNameNotNull() {
        Parrot p = context.getBean(Parrot.class);
        assertNotNull(p);

        p.setName("Aga");
        assertEquals("Aga", p.getName());
    }
}
