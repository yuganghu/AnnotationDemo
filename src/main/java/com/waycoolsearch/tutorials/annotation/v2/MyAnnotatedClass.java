package com.waycoolsearch.tutorials.annotation.v2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

@MyAnnotation()
public class MyAnnotatedClass {
  private static final Logger log = Logger.getLogger(MyAnnotatedClass.class);

  @MyAnnotation(value = "string value 1", number = 1, date = "01-01-1978")
  public void doMethod() {}

  @MyAnnotation(value = "string value 2", number = 10, date = "01-02-1978")
  public static void doMethod(Integer n1) {}

  @MyAnnotation(value = "string value 3", number = 100, date = "01-03-1978")
  public void doMethod(Integer n1, int n2) {}

  @MyAnnotation()
  public void doMethod(String data, int n1) {}

  public static void displayMethodAnnotation(String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
    try {
      Method m = MyAnnotatedClass.class.getMethod(methodName, parameterTypes);
      MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
      log.info(annotation.value() + "\t" + annotation.number() + "\t" + annotation.date());
    }
    catch (NoSuchMethodException exc) {
      log.error("Method Not Found.");
      throw exc;
    }
  }

  public static void displayClassAnnotations() {

    MyAnnotation annotation = MyAnnotatedClass.class.getAnnotation(MyAnnotation.class);
    log.info("displayClassAnnotations+++++" + annotation);
    log.info(annotation.value() + "\t" + annotation.number() + "\t" + annotation.date());
  }

  public static void main(String arg[]) throws Exception{
    displayMethodAnnotation("doMethod");
    displayMethodAnnotation("doMethod", Integer.class);
    displayMethodAnnotation("doMethod", Integer.class, int.class);
    displayMethodAnnotation("doMethod", String.class, int.class);

    displayClassAnnotations();

    // All annotations
    printAllAnnotations();
  }

  public static void printAllAnnotations() {
    Class<MyAnnotatedClass> thisClass = MyAnnotatedClass.class;
    Annotation[] annotations = thisClass.getAnnotations();
    log.info("Class annotations ---" + annotations);
    for (Annotation annotation : annotations) {
      log.info(annotation.toString());
    }
    System.out.println("Declared methods annotations ---");
    for (Method m : thisClass.getDeclaredMethods()) {
      log.info(m.getName() + " annotations" + m.getAnnotations());
    }
  }
}
