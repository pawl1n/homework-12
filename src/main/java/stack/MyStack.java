package stack;

import stack.exceptoins.EmptyStackException;
import stack.exceptoins.FullStackException;

import java.util.Arrays;
import java.util.Optional;

public class MyStack<E> implements Stackable<E> {
    private static final int MAX_CAPACITY = 10;
    private static final int INITIAL_TOP_VALUE = -1;
    private static final String EMPTY_STACK_MESSAGE = "Stack is empty";
    private static final String FULL_STACK_MESSAGE = "Stack is full";
    private final E[] elements;
    private int top;


    @SuppressWarnings("unchecked")
    public MyStack() {
        elements = (E[]) new Object[MAX_CAPACITY];
        top = INITIAL_TOP_VALUE;
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException(EMPTY_STACK_MESSAGE);

        return elements[top];
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException(EMPTY_STACK_MESSAGE);

        return elements[top--];
    }

    public Optional<E> popOptional() {
        if (isEmpty()) return Optional.empty();

        return Optional.of(elements[top--]);
    }

    @Override
    public void push(E element) throws FullStackException {
        if (isFull()) throw new FullStackException(FULL_STACK_MESSAGE);

        elements[++top] = element;
    }

    @Override
    public boolean isEmpty() {
        return top == INITIAL_TOP_VALUE;
    }

    @Override
    public boolean isFull() {
        return top == MAX_CAPACITY - 1;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "elements=" + Arrays.toString(elements) +
                ", top=" + top +
                '}';
    }
}
