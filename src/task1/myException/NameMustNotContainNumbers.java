package task1.myException;

public class NameMustNotContainNumbers extends Exception {
    public NameMustNotContainNumbers(String message) {
        super(message);
    }
}