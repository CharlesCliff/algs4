package org.chenyang.algs4.chapter1;

/**
 * TestPrivate
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/6/7
 *         Time:11:53
 */
public class TestPrivate {

  private int a;
  
  public TestPrivate(){}

  public TestPrivate(TestPrivate t) {
    this.a = t.a;
  }
  
  public void setA(int a ) {
    this.a = a;
  }

  public static void main(String[] args) {
    TestPrivate t = new TestPrivate();
    t.setA(3);
    TestPrivate t2 = new TestPrivate(t);
    System.out.println(t2.a);
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    Stack<Integer> stack2 = new Stack<>(stack);
    System.out.println(stack2.peek());
  }
}
