package org.chenyang.algs4.chapter1;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by chenyang on 16/6/12.
 */
public interface TwoWayIterator<T> extends Iterator<T>{

  boolean hasPrevious();

  boolean hasNext();

  T next();

  T previous();
}
