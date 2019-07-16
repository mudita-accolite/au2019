package com.accolite.au;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface Servlet {

	String name();

	String url();

}

