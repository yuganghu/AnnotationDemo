package com.waycoolsearch.tutorials.annotation;

import org.junit.Test;

public class TestMyAnnotatedClass {

	@Test
	public void test() {
		MyAnnotatedClass.displayAnnotation("doMethod");
		MyAnnotatedClass.displayAnnotation("doMethod", Integer.class);
		MyAnnotatedClass
				.displayAnnotation("doMethod", Integer.class, int.class);
	}
}
