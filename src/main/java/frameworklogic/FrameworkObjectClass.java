package frameworklogic;

import annotations.After;
import annotations.Before;
import annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;

public class FrameworkObjectClass {
    private static final Logger logger = LoggerFactory.getLogger(CustomJUnit.class);

    public void runTests(String packageWithTests) {
        List<Class<?>> classes = ClassFinder.find(packageWithTests);
        FrameworkObjectClass frameworkObjectClass = new FrameworkObjectClass();
        for (Class<?> c : classes) {
            logger.info(c.getName());
            frameworkObjectClass.runTest(c);
            logger.info("");
        }
    }

    private void runTest(Class testClass) {
        try {
            Object workObject = testClass.newInstance();
            List<Method> methodBefore = ReflectionHelper.findAnnotatedMethods(testClass, Before.class);
            for (Method method : methodBefore) {
                ReflectionHelper.callMethod(workObject, method.getName(), method.getParameters());
                logger.info("Before done");
            }

            int testSequenceNumber = 1;
            List<Method> methodTests = ReflectionHelper.findAnnotatedMethods(testClass, Test.class);
            for (Method method : methodTests) {
                logger.info("Test" + testSequenceNumber);
                testSequenceNumber++;
                ReflectionHelper.callMethod(workObject, method.getName(), method.getParameters());
            }

            List<Method> methodAfter = ReflectionHelper.findAnnotatedMethods(testClass, After.class);
            for (Method method : methodAfter) {
                ReflectionHelper.callMethod(workObject, method.getName(), method.getParameters());
                logger.info("After done");
            }
        } catch (Throwable e) {
            logger.error("Error occurred:",e);
            for (StackTraceElement element : e.getStackTrace())
                logger.error(element.toString());
        }
    }
}
