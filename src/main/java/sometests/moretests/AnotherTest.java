package sometests.moretests;

import annotations.Before;
import annotations.MyAssertions;
import annotations.Test;
import someworkpackage.SomeOperationsClass;

public class AnotherTest {
    SomeOperationsClass someOperationsClass;

    @Before
    public void SomeBeforeMethod() {
        someOperationsClass = new SomeOperationsClass(3);
    }

    @Test
    public void TestAssertNotNotNull() {
        MyAssertions.assertThat(someOperationsClass.someFunctionThatMayReturnNull(3)).assertNotNull();
        MyAssertions.assertThat(someOperationsClass.someFunctionThatMayReturnNull(4)).assertNotNull();
    }
}
