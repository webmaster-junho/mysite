package kr.co.itcen.mysite.security;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface Auth {
	//public enum Role{USER,ADMIN};

	//public Role role() default Role.USER;
	public String value() default "USER";//입력안하면 USER야

	//public int test() default 1;
}
