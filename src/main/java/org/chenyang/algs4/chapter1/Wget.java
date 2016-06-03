package org.chenyang.algs4.chapter1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Wget
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/5/30
 *         Time:09:46
 */
public class Wget {
  public static void main(String[] args) {
    try {
      URL url = new URL(args[0]);
      URLConnection connection = url.openConnection();
      HttpURLConnection urlConnection = null;
      if (connection instanceof HttpURLConnection ) {
        urlConnection = (HttpURLConnection)connection;
      }
      if (urlConnection!=null) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        RandomAccessFile randomAccessFile = new RandomAccessFile("name", "rw");
        int ctxlength = urlConnection.getContentLength();

      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
