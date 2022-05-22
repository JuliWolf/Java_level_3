package Lesson_7.Homework;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Class suitClass = SuitClass.class;
        Object suitInstance = suitClass.getDeclaredConstructor().newInstance();
        Method[] methods = suitClass.getDeclaredMethods();
        List<Method> testMethods = new ArrayList<>();

        Method afterSuitMethod = null;
        Method beforeSuitMethod = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
                continue;
            }

            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuitMethod == null) {
                    beforeSuitMethod = method;
                    continue;
                }
                throw new RuntimeException("There are more than 1 BeforeSuite annotation");
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuitMethod == null) {
                    afterSuitMethod = method;
                    continue;
                }
                throw new RuntimeException("There are more than 1 AfterSuite annotation");
            }
        }

        testMethods.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });

        if (beforeSuitMethod != null) beforeSuitMethod.invoke(suitInstance);
        for (Method method : testMethods) {
            method.invoke(suitInstance);
        }
        if (afterSuitMethod != null) afterSuitMethod.invoke(suitInstance);
    }
}
