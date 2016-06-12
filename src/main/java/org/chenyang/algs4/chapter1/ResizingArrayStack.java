package org.chenyang.algs4.chapter1;

import java.util.Iterator;

/**
 * ResizingArrayStack
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/6/5
 *         Time:21:30
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

  private Item[] a = (Item[]) new Object[1];
  private int N = 0;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(Item item) {
    if (N == a.length) {
      resize(2 * N);
    }
    a[N++] = item;
  }

  public Item pop() {
    Item item = a[--N];
    a[N] = null;
    if (N > 0 && N == a.length / 4) {
      resize(a.length / 2);
    }
    return item;
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = N;

    public boolean hasNext() {
      return i > 0;
    }

    public Item next() {
      return a[--i];
    }

    public void remove() {
    }
  }

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

}
