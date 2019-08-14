package lol.cicco.optimisticlock.annotation;

import lol.cicco.optimisticlock.exception.OptimisticLockException;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Retry {

    int value() default 3;

    Class<? extends Throwable> forException() default OptimisticLockException.class;
}
