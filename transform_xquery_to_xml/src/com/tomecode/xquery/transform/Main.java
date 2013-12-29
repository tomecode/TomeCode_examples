package com.tomecode.xquery.transform;

import java.io.InputStream;
import java.io.PrintStream;

import org.w3c.xqparser.XPath;
import org.w3c.xqparser.XQueryToXQueryX;

/**
 * How to transform XQuery to XML
 * 
 * Requirements: 
 * 
 * 1.download http://www.w3.org/2007/01/applets/xquery.zip and compile and create jar 
 * 2. java 1.5 or higher
 * 
 * @author TomeCode.com
 * 
 *
 */
public final class Main
{

  /**
   * @param args
   * @throws Exception
   */
  public final static void main(String[] args) throws Exception
  {
    // print XML to console
    PrintStream ps = new PrintStream(System.out);

    // sample xQuery
    InputStream inputStream = Main.class.getResourceAsStream("sample.xq");

    XQueryToXQueryX xQueryToXQueryX = new XQueryToXQueryX();
    // transform xQuery to XML
    xQueryToXQueryX.transform(new XPath(inputStream).XPath2(), ps);
  }
}
