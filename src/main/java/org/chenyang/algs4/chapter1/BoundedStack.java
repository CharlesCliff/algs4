package org.chenyang.algs4.chapter1;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * BoundedStack
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/6/9
 *         Time:13:24
 */
public class BoundedStack<T> {

  private LinkedList<T> list;
  private int limit;

  public BoundedStack(int limit) {
    this.limit = limit;
  }

  public T pop(T item) {
    if (isEmpty())
      throw new NoSuchElementException("bounded stack underflow");
    return list.pop();
  }

  public void push(T item) {
    if (isFull())
      list.removeFirst();
    list.push(item);
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public boolean isFull() {
    return list.size()==limit;
  }

}
