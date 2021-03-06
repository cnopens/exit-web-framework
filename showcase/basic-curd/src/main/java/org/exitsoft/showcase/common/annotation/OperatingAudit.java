package org.exitsoft.showcase.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperatingAudit {
	
	/**
	 * 模块名称
	 * 
	 */
	String value() default "";
	
	/**
	 * 功能名称
	 * @return
	 */
	String function() default "";
}
