package com.gcg.mektup.annotation.marker;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventSubscriberService {

    long eventId() default -1L;

    String queue();

    boolean idempotency() default false;

}
