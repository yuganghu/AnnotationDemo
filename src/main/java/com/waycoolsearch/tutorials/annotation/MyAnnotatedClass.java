package com.waycoolsearch.tutorials.annotation;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class MyAnnotatedClass {

  private static final Logger log = Logger.getLogger(MyAnnotatedClass.class);

  @MyAnnotation(value = "string value 1", number = 1, date = "01-01-1978")
  public void doMethod() {}

  @MyAnnotation(value = "string value 2", number = 10, date = "01-02-1978")
  public static void doMethod(Integer n1) {}

  @MyAnnotation(value = "string value 3", number = 100, date = "01-03-1978")
  public void doMethod(Integer n1, int n2) {}

  public static void displayAnnotation(String methodName, Class<?>... parameterTypes) {
    try {
      Method m = MyAnnotatedClass.class.getMethod(methodName, parameterTypes);
      MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
      log.info(annotation.value() + "\t" + annotation.number() + "\t" + annotation.date());
    }
    catch (NoSuchMethodException exc) {
      log.error("Method Not Found.");
    }
  }

  public static void main(String arg[]) {
    displayAnnotation("doMethod");
    displayAnnotation("doMethod", Integer.class);
    displayAnnotation("doMethod", Integer.class, int.class);
  }
}
