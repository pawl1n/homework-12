package stack.exceptoins;

public class EmptyStackException extends Exception {
    public EmptyStackException() {
        super();
    }

    public EmptyStackException(String message) {
        super(message);
    }
}
