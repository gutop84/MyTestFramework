package annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAssertions {
    private static final Logger logger = LoggerFactory.getLogger(CustomJUnit.class);

    private static String value;

    public MyAssertions(String valueOf) {
        this.value = valueOf;
    }

    public boolean assertEquals(String string) {
        if (this.value.equals(string))
            logger.info("Test passed");
        else
            logger.info("Test failed: expected [" + string + "] but got [" + value + "]");
        return this.value.equals(string);
    }

    public boolean assertTrue() {
        if (this.value.equals(String.valueOf("true")))
            logger.info("Test passed");
        else
            logger.info("Test failed: expected [" + true + "] but got [" + value + "]");
        return this.value.equals(String.valueOf("true"));
    }

    public boolean assertNotNull() {
        if (!this.value.equals(String.valueOf("null")))
            logger.info("Test passed");
        else
            logger.info("Test failed: got [" + null + "]");
        return !this.value.equals(String.valueOf("null"));
    }

    public static MyAssertions assertThat(Object resulfOfSomeFunction) {
        MyAssertions myAssertions = new MyAssertions(String.valueOf(resulfOfSomeFunction));
        return myAssertions;
    }
}
