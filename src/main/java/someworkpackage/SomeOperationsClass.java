package someworkpackage;

public class SomeOperationsClass {
    private int someValue;

    public SomeOperationsClass(int someValue) {
        this.someValue = someValue;
    }

    public SomeOperationsClass() {
        this.someValue = 0;
    }

    public int someAddFunction(int a, int b) {
        return someValue + a + b;
    }

    public boolean someLogicFunction(boolean a, boolean b) {
        return a && b;
    }

    public Integer someFunctionThatMayReturnNull(Integer i) {
        if (i == someValue) {
            return Integer.valueOf(i);
        } else
            return null;
    }
}
