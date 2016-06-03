package org.chenyang.algs4.chapter1;

/**
 * Sattolo
 * the algorithm create random array
 * Created with IntelliJ IDEA
 * <a href="https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#Sattolo.27s_algorithm">Sattolo Algorithm</a>
 * @author chenyang
 *         Date:16/5/30
 *         Time:15:28
 */
public class Sattolo {

  public void cycle(int[] arr) {
    int N = arr.length;
    for(int i = N; i>0; i--) {
      int j = (int)Math.random()*(i-1);
      int temp = arr[j];
      arr[j] = arr[i];
      arr[i] = temp;
    }
  }
}
