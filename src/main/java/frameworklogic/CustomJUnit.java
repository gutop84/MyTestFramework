package frameworklogic;

public class CustomJUnit {
    public static void runTests(String packageWithTests) {
        FrameworkObjectClass frameworkObject = new FrameworkObjectClass();
        frameworkObject.runTests(packageWithTests);
    }
}
