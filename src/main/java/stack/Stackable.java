package stack;

import stack.exceptoins.EmptyStackException;
import stack.exceptoins.FullStackException;

public interface Stackable<E> {
    E peek() throws EmptyStackException;
    E pop() throws EmptyStackException;
    void push(E element) throws FullStackException;
    boolean isEmpty();
    boolean isFull();

}
