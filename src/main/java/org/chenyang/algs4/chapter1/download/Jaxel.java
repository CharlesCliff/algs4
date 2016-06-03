package org.chenyang.algs4.chapter1.download;

import edu.princeton.cs.algs4.StdOut;

/**
 * Jaxel
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/5/30
 *         Time:10:26
 *利用URLConnection获取要下载文件的长度、头部等相关信息，并设置响应的头部信息。
 *并且通过URLConnection获取输入流，将文件分成指定的块，每一块单独开辟一个线程完成数据的读取、写入。
 *通过输入流读取下载文件的信息，然后将读取的信息用RandomAccessFile随机写入到本地文件中。
 *同时，每个线程写入的数据都文件指针也就是写入数据的长度，需要保存在一个临时文件中。
 *这样当本次下载没有完成的时候，下次下载的时候就从这个文件中读取上一次下载的文件长度，
 *然后继续接着上一次的位置开始下载。并且将本次下载的长度写入到这个文件中
 */
public class Jaxel {

  private int threadNum;

  private String urlStr;

  public void usage() {
    StdOut.println("Usage: jaxel [options] url");
    StdOut.println("-s x\tSpecify maximum speed (bytes per second)\n" +
        "-n x\tSpecify maximum number of connections\n" +
        "-o f\tSpecify local output file\n" +
        "-S [x]\tSearch for mirrors and download from x servers\n" +
        "-H x\tAdd header string\n" +
        "-U x\tSet user agent\n" +
        "-N\tJust don't use any proxy server\n" +
        "-q\tLeave stdout alone\n" +
        "-v\tMore status information\n" +
        "-a\tAlternate progress indicator\n" +
        "-h\tThis information\n" +
        "-V\tVersion information");
  }

  private void parseArgs(String[] args) {
    int len = args.length;
    for (int i=0; i<len; i++) {
      if (args[i].toLowerCase().equals("-n")) {
        this.threadNum = Integer.parseInt(args[i+1]);
        this.threadNum = this.threadNum>0?this.threadNum:1;
        i++;
      }
      if (args[i].toLowerCase().equals("-h")) {
        this.usage();
        return;
      }
    }
    this.urlStr = args[len-1];
  }

  public static void main(String[] args) {
    Jaxel jaxel = new Jaxel();
    jaxel.usage();
    jaxel.parseArgs(args);

  }

}


/**
 * LogUtil 日志类
 * @author chenyang
 *
 */
abstract class LogUtils {

  public static void log(Object message) {
    System.err.println(message);
  }

  public static void log(String message) {
    System.err.println(message);
  }

  public static void log(int message) {
    System.err.println(message);
  }

  public static void info(Object message) {
    System.out.println(message);
  }

  public static void info(String message) {
    System.out.println(message);
  }

  public static void info(int message) {
    System.out.println(message);
  }
}
