package stack;

import org.junit.jupiter.api.Test;
import stack.exceptoins.EmptyStackException;
import stack.exceptoins.FullStackException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MyStackTest {

    @Test
    void shouldPeek() throws FullStackException, EmptyStackException {
        // given
        MyStack<String> stack = new MyStack<>();

        // when
        stack.push("first string");
        stack.push("second string");
        stack.push("third string");

        // then
        assertThat(stack.peek()).isEqualToIgnoringCase("third string");
    }

    @Test
    void shouldNotPeek() {
        // given
        MyStack<String> stack;

        // when
        stack = new MyStack<>();

        // then
        assertThatThrownBy(stack::peek).hasMessage("Stack is empty");
    }

    @Test
    void shouldPop() throws FullStackException, EmptyStackException {
        // given
        MyStack<String> stack = new MyStack<>();

        // when
        stack.push("first string");

        // then
        assertThat(stack.pop()).isEqualToIgnoringCase("first string");
    }

    @Test
    void shouldNotPop() throws FullStackException, EmptyStackException {
        // given
        MyStack<String> stack = new MyStack<>();

        // when
        stack.push("first string");
        stack.pop();

        // then
        assertThatThrownBy(stack::pop).hasMessage("Stack is empty");
    }

    @Test
    void shouldPush() {
        // given
        MyStack<String> stack;

        // when
        stack = new MyStack<>();

        // then
        assertThatCode(() -> stack.push("first string")).doesNotThrowAnyException();
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    void shouldNotPush() throws FullStackException {
        // given
        MyStack<String> stack = new MyStack<>();

        // when
        stack.push("test1");
        stack.push("test2");
        stack.push("test3");
        stack.push("test4");
        stack.push("test5");
        stack.push("test6");
        stack.push("test7");
        stack.push("test8");
        stack.push("test9");
        stack.push("test10");

        // then
        assertThatThrownBy(() -> stack.push("error")).hasMessage("Stack is full");
    }

    @Test
    void shouldBeEmpty() {
        // given
        MyStack<String> stack;

        // when
        stack = new MyStack<>();

        // then
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void shouldNotBeEmpty() throws FullStackException {
        // given
        MyStack<String> stack = new MyStack<>();

        // when
        stack.push("test");

        // then
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    void shouldNotBeFull() throws FullStackException {
        // given
        MyStack<String> stack = new MyStack<>();

        // when
        stack.push("test");

        // then
        assertThat(stack.isFull()).isFalse();
    }

    @Test
    void shouldBeFull() throws FullStackException {
        // given
        MyStack<String> stack = new MyStack<>();

        // when
        stack.push("test1");
        stack.push("test2");
        stack.push("test3");
        stack.push("test4");
        stack.push("test5");
        stack.push("test6");
        stack.push("test7");
        stack.push("test8");
        stack.push("test9");
        stack.push("test10");

        // then
        assertThat(stack.isFull()).isTrue();
    }

    @Test
    void shouldPopOptional() throws FullStackException {
        // given
        MyStack<String> stack = new MyStack<>();

        // when
        stack.push("test");

        // then
        assertThat(stack.popOptional()).isPresent().get().isEqualTo("test");
    }

    @Test
    void shouldNotPopOptional() {
        // given
        MyStack<String> stack = new MyStack<>();

        // when
        Optional<String> item = stack.popOptional();

        // then
        assertThat(item).isNotPresent();
    }
}