package org.chenyang.algs4.chapter1;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Steque
 * Created with IntelliJ IDEA
 * A stack-ended queue or steque is a data type that supports push, pop, and enqueue.
 * Knuth calls it an output-restricted deque. Implement it using a singly-linked list.
 * @author chenyang
 *         Date:16/6/12
 *         Time:10:17
 */
public class Steque<Item> implements Iterable<Item>{
  private Node<Item> head;
  private Node<Item> tail;
  private int N;


  private class Node<Item> {
    private Item item;
    private Node<Item> next;
    private Node<Item> previous;
    Node() {
      this.next = null;
      this.previous = null;
    }

    Node(Item item) {
      this.item = item;
      this.next = null;
      this.previous = null;
    }
  }

  public Steque() {
    head = new Node<>();
    tail = new Node<>();
    head.next = tail;
    head.previous = null;;
    tail.next = null;
    tail.previous = head;
    N = 0;
  }

  public boolean isEmpty() {
    return N==0;
  }

  public int size() {
    return N;
  }

  public boolean enqueue(Item item) {
    Node<Item> node = new Node<>(item);
    head.next.previous = node;
    node.next = head.next;
    node.previous = head;
    head.next = node;
    N++;
    return true;
  }

  public boolean push(Item item) {
    Node<Item> node = new Node<>(item);
    tail.previous.next = node;
    node.previous = tail.previous;
    node.next = tail;
    tail.previous = node;
    N++;
    return false;
  }

  public Item pop() {
    Node<Item> node = tail.previous;
    tail.previous = node.previous;
    node.previous.next = tail;
    N--;
    return node.item;
  }

  public Item peek() {
    if (isEmpty())
      throw new NoSuchElementException();
    return tail.previous.item;
  }

  /**
   * Returns an iterator over elements of type {@code T}.
   *
   * @return an Iterator.
   */
  @Override
  public Iterator<Item> iterator() {
    return new StequeIterator<Item>(head);
  }

  private class StequeIterator<Item> implements Iterator<Item> {
    Node<Item> current;

    public StequeIterator(Node<Item> head) {
      current = head;
    }

    public boolean hasNext() {
      return current.next!=null && current.next.next!=null;
    }

    public Item next() {
      if (!hasNext())
        throw new NoSuchElementException();
      current = current.next;
      return current.item;
    }

  }

  public static void main(String[] args) {
    Steque<Integer> steque = new Steque();
    steque.enqueue(1);
    steque.push(2);
    steque.enqueue(3);
    steque.push(4);
    for (Integer i: steque) {
      StdOut.println(i);
    }
  }
}
