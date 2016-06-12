package org.chenyang.algs4.chapter1;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * QueueWithTwoStacks
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/6/12
 *         Time:10:16
 */
public class QueueWithTwoStacks<T> {

  private Stack<T> stack1;
  private Stack<T> stack2;
  private int N;

  QueueWithTwoStacks() {
    stack1 = new Stack<T>();
    stack2 = new Stack<T>();
    N = 0;
  }

  public boolean isEmpty() {
    return N==0;
  }

  public int size() {
    return N;
  }

  public boolean enqueue(T item) {
    if (stack2.isEmpty()) {
      stack1.push(item);
      N++;
    }
    else {
      while (!stack2.isEmpty()) {
        stack1.push(stack2.pop());
      }
      stack1.push(item);
      N++;
    }
    return true;
  }

  public T dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("queue underflow");
    if (stack2.isEmpty()) {
      while(!stack1.isEmpty())
        stack2.push(stack1.pop());
      N--;
      return stack2.pop();
    } else {
      N--;
      return stack2.pop();
    }
  }

  public static void main(String[] args) {
    QueueWithTwoStacks<Integer> q = new QueueWithTwoStacks<>();
    q.enqueue(1);
    q.enqueue(3);
    q.enqueue(4);
    StdOut.println(q.dequeue());
    q.enqueue(5);
    StdOut.println(q.dequeue());
    StdOut.println(q.dequeue());
    assert q.isEmpty():"not empty";
    StdOut.println(q.dequeue());
  }
}
