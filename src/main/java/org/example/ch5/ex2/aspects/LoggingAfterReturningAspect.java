package org.example.ch5.ex2.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAfterReturningAspect {

    Logger logger = Logger.getLogger(LoggingAfterReturningAspect.class.getName());

    @AfterReturning(value = "@annotation(LogAfterReturn)", returning = "returnedVal")
    public void log(Object returnedVal) {
        logger.info("After returning advice: Processing the result - " + returnedVal);
    }
}
