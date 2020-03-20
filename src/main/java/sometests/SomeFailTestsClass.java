package sometests;

import annotations.Before;
import frameworklogic.MyAssertions;
import annotations.Test;
import someworkpackage.SomeOperationsClass;

public class SomeFailTestsClass {
    SomeOperationsClass someOperationsClass;

    @Before
    public void SomeBeforeMethod() {
        someOperationsClass = new SomeOperationsClass(3);
    }

    @Test
    public void TestAssertNotEquals() {
        MyAssertions.assertThat(someOperationsClass.someAddFunction(3, 3)).assertEquals("8");
    }

    @Test
    public void TestAssertNotTrue() {
        MyAssertions.assertThat(someOperationsClass.someLogicFunction(false, false)).assertTrue();
    }

    @Test
    public void TestAssertNotNotNull() {
        MyAssertions.assertThat(someOperationsClass.someFunctionThatMayReturnNull(4)).assertNotNull();
    }
}
