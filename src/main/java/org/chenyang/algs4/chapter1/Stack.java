package org.chenyang.algs4.chapter1;

import edu.princeton.cs.algs4.StdOut;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/6/6
 *         Time:12:47
 */
public class Stack<Item> implements Iterable<Item> {

  private Node<Item> first;
  private int N;
  private int pushPopCounter = 0;

  private static class Node<Item> {
    private Item item;
    private Node<Item> next;

    public Node(){}

    public Node(Node<Item> x) {
      item = x.item;
      if(x.next!=null)
        next = new Node(x.next);
    }
  }

  public Stack() {
    first  = null;
    N = 0;
  }

  public Stack(Stack<Item> s) {
    first = new Node(s.first);
    N = s.N;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    Node<Item> oldfirst = first;
    first = new Node<Item>();
    first.item = item;
    first.next = oldfirst;
    N++;
    pushPopCounter++;
  }

  public Item pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("stack underflow");
    }
    Item item = first.item;
    first = first.next;
    N--;
    pushPopCounter++;
    return item;
  }

  public Item peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("stack underflow");
    }
    return first.item;
  }

  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Item item : this) {
      s.append(item + " ");
    }
    return s.toString();
  }

  public Iterator<Item> iterator() {
    return new ListIterator<Item>(first, pushPopCounter);
  }

  private class ListIterator<Item> implements Iterator<Item> {
    private Node<Item> current;
    private int pushPopCounter;

    public ListIterator(Node<Item> first) {
      current = first;
    }

    public ListIterator(Node<Item> first, int counter) {
      current = first;
      pushPopCounter = counter;

    }
    public boolean hasNext() {
      if (this.pushPopCounter!=Stack.this.pushPopCounter)
        throw new ConcurrentModificationException();
      return current != null;
    }

    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    Stack<Integer> copyStack = new Stack(stack);
    Integer item = stack.first.item;
    for (Integer s: copyStack) {
      StdOut.println(s);
    }
  }
}
