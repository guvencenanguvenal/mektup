package com.gcg.mektup.core.annotation.marker;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@RestController
public @interface EventSubscriber {

    @AliasFor(
            annotation = Controller.class
    )
    String value() default "";

}
