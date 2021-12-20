package com.play.ground.domain.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SearchDataEnqueue {

    SearchDataEnqueueType type() default SearchDataEnqueueType.SHOP;
}
