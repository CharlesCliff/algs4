package org.chenyang.algs4.chapter1.download;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * DownloadThread
 * download from url with single thread
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/5/30
 *         Time:11:27
 */
public class DownloadThread extends Thread {

  final private static int BYTE_LEN = 1024;

  private static final Logger logger = LoggerFactory.getLogger(DownloadThread.class);

  private URL url;

  private long startPos;

  private long endPos;

  private SaveFile file;

  private HttpURLConnection httpURLConnection;

  DownloadThread(String urlStr) throws IOException {
    this.url = new URL(urlStr);
    startPos = 0;
    endPos = 0;
    //init file
    String filename = url.getPath();
    String[] path = filename.split("/");
    filename = path[path.length-1];
    file = new SaveFile(filename, startPos);
  }

  DownloadThread(String urlStr, long startPos, long endPos, String fileName) throws IOException {
    this.url = new URL(urlStr);
    this.startPos = startPos;
    this.endPos = endPos;
    //init file
    file = new SaveFile(fileName, this.startPos);
  }

  @Override
  public void run() {

    logger.info("thread....{}....begin\n", Thread.currentThread().getId());
    try {
      initHttpConnection();
      byte[] buffer = new byte[BYTE_LEN];
      InputStream inputStream = httpURLConnection.getInputStream();

      int length = -1;
      while((length=inputStream.read(buffer))>0 && startPos<endPos ) {
        startPos += file.write(buffer, 0, length);
        logger.info("thread...{}...downloading...{}",
            Thread.currentThread().getId(),
            startPos);
      }
      logger.info("thread....{}....end\n", Thread.currentThread().getId());
    } catch (IOException e) {
      e.printStackTrace();
      logger.debug("test logger");
    } finally {
      closeFile(file);
    }
  }

  private void initHttpConnection() {
    try {
      httpURLConnection = (HttpURLConnection) url.openConnection();
      String key = "byte=" + this.startPos + "-";
      if (endPos > 0 && endPos > startPos) {
        httpURLConnection.setRequestProperty("RANGE", key + endPos);
      } else {
        httpURLConnection.setRequestProperty("RANGE", key);
      }
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void closeFile(SaveFile file) {
    try {
      if (file!=null)
        file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    try {
      DownloadThread download = new DownloadThread(args[0]);
      download.run();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
