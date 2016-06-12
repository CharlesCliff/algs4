package org.chenyang.algs4.chapter1;

import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;
import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Tail
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/6/9
 *         Time:12:46
 */
public class Tail {

  public static void main(String[] args) throws WrongNumberArgsException{
    if (args.length<3) throw new WrongNumberArgsException(String.valueOf(args.length));
    int lineNum = Integer.parseInt(args[0]);
    StdOut.println(System.getProperty("user.dir"));
    String filename = args[2];
    File file = new File(filename);

    try {
      BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
      System.setIn(in);
      Queue<String> fileQueue = new Queue<>();
      String line;

      while((line=StdIn.readLine())!= null ) {
        if (fileQueue.size()==lineNum)
          fileQueue.dequeue();
        fileQueue.enqueue(line);
      }

      for (String s: fileQueue)
        StdOut.println(s);
     } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
