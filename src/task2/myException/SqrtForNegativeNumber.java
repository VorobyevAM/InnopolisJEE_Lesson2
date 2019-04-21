package task2.myException;

import java.io.PrintStream;

public class SqrtForNegativeNumber extends ArithmeticException{

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    public SqrtForNegativeNumber(String s) {
        super(s);
    }

}
