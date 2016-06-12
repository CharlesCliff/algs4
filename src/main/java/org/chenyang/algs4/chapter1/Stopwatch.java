package org.chenyang.algs4.chapter1;

/**
 * Stopwatch
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/6/11
 *         Time:21:14
 */
public class Stopwatch {
  private final long start;

  public Stopwatch() {
    start = System.currentTimeMillis();
  }

  public double elaspedTime() {
    long now = System.currentTimeMillis();
    return (now - start) / 1000.0;
  }


}
