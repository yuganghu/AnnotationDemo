package com.waycoolsearch.tutorials.annotation.v2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
//METHOD only
//@Target(ElementType.METHOD)
public @interface MyAnnotation {
   String value() default "default value";
   String date() default "default date";
   int number() default 10000;
}
