package com.play.ground.domain.common;

import com.play.ground.config.EnqueueProcessType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShopTargetQueue {

    EnqueueProcessType type();
}
