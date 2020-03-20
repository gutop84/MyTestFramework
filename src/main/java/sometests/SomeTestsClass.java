package sometests;

import annotations.After;
import annotations.Before;
import annotations.MyAssertions;
import annotations.Test;
import someworkpackage.SomeOperationsClass;

public class SomeTestsClass {
    SomeOperationsClass someOperationsClass;
    int i;

    @Before
    public void SomeBeforeMethod() {
        someOperationsClass = new SomeOperationsClass(3);
        i = 8;
    }

    @Test
    public void TestAssertEquals() {
        MyAssertions.assertThat(someOperationsClass.someAddFunction(3, 3)).assertEquals("9");
    }

    @Test
    public void TestAssertTrue() {
        i = i + 1;
        MyAssertions.assertThat(someOperationsClass.someLogicFunction(true, true)).assertTrue();
    }

    @Test
    public void TestAssertNotNull() {
        MyAssertions.assertThat(someOperationsClass.someFunctionThatMayReturnNull(3)).assertNotNull();
    }

    @After
    public void SomeAfterMethod() {
        System.out.println("i = " + i);
    }
}
