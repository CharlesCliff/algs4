package org.chenyang.algs4.chapter1.download;

import java.io.*;

/**
 * SaveFile
 * wrap up RandomAccessFile to write file with start position
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/5/30
 *         Time:11:06
 */
public class SaveFile {

  private String fileName;

  private long startPos;

  private RandomAccessFile raf;

  public SaveFile(String fileName, long startPos) throws IOException {
    this.fileName = fileName;
    this.startPos = startPos;
    this.raf = new RandomAccessFile(this.fileName, "rw");
    this.raf.seek(startPos);
  }

  public int write(byte[] buffer, int off, int length) {
    try {
      this.raf.write(buffer, off, length);
      return length;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return -1;
  }

  public void close() throws IOException{
    if (this.raf!=null ) {
      this.raf.close();
    }
  }

  public String getFileName() {
    return fileName;
  }

  public long getStartPos() {
    return startPos;
  }

  public RandomAccessFile getRaf() {
    return raf;
  }

}
