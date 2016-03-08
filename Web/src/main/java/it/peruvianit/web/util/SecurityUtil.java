package it.peruvianit.web.util;

import org.jboss.resteasy.core.ResourceMethod;

import it.peruvianit.commons.annotation.resource.ServiceIdentifier;
import it.peruvianit.commons.annotation.resource.TypeAccessService;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public final class SecurityUtil {
	public static boolean isMethodSecure(final ResourceMethod resourceMethod) {
        boolean isSecured = false;
        final Method method = resourceMethod.getMethod();
        final Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        for (final Annotation annotation : declaredAnnotations) {
            if (SecurityUtil.isAnnotationSecure(annotation)) {
                isSecured = true;
                break;
            }

        }
        return isSecured;
    }
	
	public static boolean isAnnotationSecure(final Annotation annotation) {
        boolean isSecured = false;
        if (annotation instanceof ServiceIdentifier) {
        	if (((ServiceIdentifier) annotation).typeAccessService() == TypeAccessService.PRIVATE){
        		isSecured = true;
        	}
        }
        return isSecured;
    }
	
}
