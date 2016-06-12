package org.chenyang.algs4.chapter1;

import edu.princeton.cs.algs4.In;

import static org.junit.Assert.*;

/**
 * Created by chenyang on 16/6/7.
 */
public class StackTest {

  @org.junit.Test
  public void isEmpty() throws Exception {

    Stack<Integer> stack = new Stack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    Stack<Integer> stack1 = new Stack<>(stack);
    assertNotNull(stack1.peek());
  }

  @org.junit.Test
  public void size() throws Exception {

  }

  @org.junit.Test
  public void push() throws Exception {

  }

  @org.junit.Test
  public void pop() throws Exception {

  }

  @org.junit.Test
  public void peek() throws Exception {

  }


  @org.junit.Test
  public void iterator() throws Exception {

  }

}