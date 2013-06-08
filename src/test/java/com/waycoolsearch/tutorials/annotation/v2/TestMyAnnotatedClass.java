package com.waycoolsearch.tutorials.annotation.v2;

import org.junit.Test;

public class TestMyAnnotatedClass {
  @Test
  public void test() throws Exception {
    MyAnnotatedClass.displayMethodAnnotation("doMethod");
    MyAnnotatedClass.displayMethodAnnotation("doMethod", Integer.class);
    MyAnnotatedClass.displayMethodAnnotation("doMethod", Integer.class, int.class);
    MyAnnotatedClass.displayMethodAnnotation("doMethod", String.class, int.class);

    MyAnnotatedClass.displayClassAnnotations();

    // All annotations
    MyAnnotatedClass.printAllAnnotations();
  }

  @Test(expected = NoSuchMethodException.class)
  public void testException() throws NoSuchMethodException {
    MyAnnotatedClass.displayMethodAnnotation("doMethod-NonExists");
  }
}
