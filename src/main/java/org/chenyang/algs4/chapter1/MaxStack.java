package org.chenyang.algs4.chapter1;

import java.util.Stack;
/**
 * MaxStack
 * Created with IntelliJ IDEA
 * return the maximum element.
 * @author chenyang
 *         Date:16/6/10
 *         Time:16:14
 */
public class MaxStack {

  private Stack<Integer> dataStack;
  private Stack<Integer> maxStack;

  public MaxStack(){}

  public void push(Integer item) {
    if (dataStack.peek()<item)
      maxStack.push(item);

    dataStack.push(item);
    dataStack.peek();
  }

  public Integer pop() {
    maxStack.pop();
    return dataStack.pop();
  }
}
