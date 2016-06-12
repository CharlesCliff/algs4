package org.chenyang.algs4.chapter1;

/**
 * FixedCapacityStackOfStrings
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/6/4
 *         Time:17:30
 */
public class FixedCapacityStackOfStrings {

  private String[] a;
  private int N = 0;

  FixedCapacityStackOfStrings(int cap) {
    a = new String[cap];
  }

  public void push(String item) {
    this.a[N++] = item;
  }

  public String pop() {
    return a[--N];
  }

  public boolean isEmpty() {
    return N>0;
  }

  public int size() {
    return N;
  }

  public boolean isFull() { return N==a.length;}
}
