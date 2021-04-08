package annotations.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;

public class ModifyAnnotationValue {
    final String fieldName;
    Object value;
    Class<? extends Annotation> annotationToAlter;
    Class[] classes;

    public ModifyAnnotationValue(String fieldName) {
        this.fieldName = fieldName;
    }

    public ModifyAnnotationValue toValue(Object annotationValue) {
        this.value = annotationValue;
        return this;
    }

    public static ModifyAnnotationValue forField(String fieldName) {
        return new ModifyAnnotationValue(fieldName);
    }

    public ModifyAnnotationValue inAnnotation(Class<? extends Annotation> annotationToAlter) {
        this.annotationToAlter = annotationToAlter;
        return this;
    }

    public ModifyAnnotationValue belongingToClasses(Class... classes) {
        this.classes = classes;
        return this;
    }

    public void alterValue() {
        Arrays.stream(classes).forEach(clazz -> {
            Annotation annotationClass = clazz.getAnnotation(annotationToAlter);
            if (annotationClass == null) {
                throw new RuntimeException("Annotation: " + annotationToAlter.getName() + "not found for class: " + clazz.getName());
            }

            Object invocationHandler = Proxy.getInvocationHandler(annotationClass);
            try {
                Field f = invocationHandler.getClass().getDeclaredField("memberValues");
                f.setAccessible(true);
                Map<String, Object> memberValues = (Map<String, Object>) f.get(invocationHandler);
                memberValues.put(fieldName, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }


        });
    }

}
