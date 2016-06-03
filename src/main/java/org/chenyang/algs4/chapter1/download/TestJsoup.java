package org.chenyang.algs4.chapter1.download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * TestJsoup
 * Created with IntelliJ IDEA
 *
 * @author chenyang
 *         Date:16/6/3
 *         Time:15:31
 */
public class TestJsoup {

  public static void main(String[] args) {

    try {
      SaveFile file = new SaveFile("url.txt", 0);
      String urlStr = "http://introcs.cs.princeton.edu/java/data/";
      URL url = new URL(urlStr);
      HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
      Document doc = Jsoup.connect(urlStr).get();
      Elements txts = doc.select("a[href*=\".txt\"");
      Elements csvs = doc.select("a[href*=\".csv\"");


      for (Element href: txts ) {
        byte[] buffer = href.attr("href").getBytes();
        file.write(buffer, 0, buffer.length);
        file.write("\n".getBytes(), 0, "\n".length());
      }

      for (Element href: csvs ) {
        byte[] buffer = href.attr("href").getBytes();
        file.write(buffer, 0, buffer.length);
        file.write("\n".getBytes(), 0, "\n".length());
      }
      file.close();

    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {

    }
  }

}
