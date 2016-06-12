package org.chenyang.algs4.chapter1;

import java.util.*;

/**
 * TwoWayIteratorList
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/6/12
 *         Time:10:04
 */
public class TwoWayIteratorList<Item> implements Iterable<Item> {

  private int length;
  private Node<Item> head;
  private Node<Item> tail;

  private class Node<Item> {
    private Item item;
    private Node<Item> next;
    private Node<Item> previous;

    Node(Item item) {
      this.item = item;
      next = null;
      previous = null;
    }
    Node() {
      next = null;
      previous = null;
    }
  }

  public TwoWayIteratorList() {
    head = new Node<Item>();
    tail = new Node<Item>();
    head.next = tail;
    tail.previous = head;
    length = 0;
  }
  
  public boolean append(Item item) {
    Node<Item> node = new Node(item);
    tail.previous.next = node;
    node.previous = tail.previous;
    tail.previous = node;
    node.next = tail;
    return true;
  }

  public Iterator<Item> iterator() {
    return new TwoWayListIterator<>(head);
  }

  private class TwoWayListIterator<Item> implements TwoWayIterator<Item> {

    private Node<Item> current;

    public TwoWayListIterator(Node<Item> node) {
      current = node;
    }

    @Override
    public boolean hasPrevious() {
      return current.previous!=null && current.previous.previous!=null;
    }

    @Override
    public boolean hasNext() {
      return current.next!=null && current.next.next!=null;
    }

    @Override
    public Item next() {
      if (!hasNext())
        throw new NoSuchElementException();
      current = current.next;
      return current.item;
    }

    @Override
    public Item previous() {
      if (!hasPrevious())
        throw new NoSuchElementException();
      current = current.previous;
      return current.item;
    }
  }
  
  public static void main(String[] args) {
    TwoWayIteratorList<Integer> list = new TwoWayIteratorList();
    list.append(1);
    list.append(2);
    list.append(5);
    for( Integer i : list) {
      System.out.println(i);
    }
    List<Integer> l = new ArrayList<>();
  }
  
}
