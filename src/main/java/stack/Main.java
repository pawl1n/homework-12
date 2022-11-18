package stack;

import stack.exceptoins.FullStackException;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();

        Optional<String> item = stack.popOptional();
        String str = item.orElse("Empty string");
        System.out.println(str);

        try {
            stack.push("first string");
            stack.push("second string");
            stack.push("third string");
            stack.push("fourth string");
            stack.push("fifth string");
            stack.push("sixth string");
            stack.push("seventh string");

        } catch (FullStackException e) {
            System.out.println("Stack is full");
        }

        System.out.println(stack);
    }
}