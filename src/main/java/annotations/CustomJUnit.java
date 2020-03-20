package annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;

public class CustomJUnit {
    private static final Logger logger = LoggerFactory.getLogger(CustomJUnit.class);

    public static void runTest(Class testClass) {
        try {
            Object workObject = testClass.newInstance();
            List<Method> methodBefore = ReflectionHelper.findAnnotatedMethods(testClass, Before.class);
            for (Method method : methodBefore) {
                ReflectionHelper.callMethod(workObject, method.getName(), method.getParameters());
                logger.info("Before done");
            }

            int i = 1;
            List<Method> methodTests = ReflectionHelper.findAnnotatedMethods(testClass, Test.class);
            for (Method method : methodTests) {
                logger.info("Test" + i);
                i++;
                ReflectionHelper.callMethod(workObject, method.getName(), method.getParameters());
            }

            List<Method> methodAfter = ReflectionHelper.findAnnotatedMethods(testClass, After.class);
            for (Method method : methodAfter) {
                ReflectionHelper.callMethod(workObject, method.getName(), method.getParameters());
                logger.info("After done");
            }
        } catch (Throwable e) {
            logger.error(e.getMessage());
            for (StackTraceElement element : e.getStackTrace())
                logger.error(element.toString());
        }
    }

    public static void runTests(String packageWithTests) {
        List<Class<?>> classes = ClassFinder.find(packageWithTests);
        for (Class<?> c : classes) {
            logger.info(c.getName());
            runTest(c);
            logger.info("");
        }
    }
}
