package it.peruvianit.commons.annotation.resource;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.METHOD;

@Target(METHOD)
@Retention(RUNTIME)
public @interface ServiceIdentifier {
	int identifier();
	TypeAccessService typeAccessService() default TypeAccessService.PUBLIC;
}
