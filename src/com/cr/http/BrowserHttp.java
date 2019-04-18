package com.cr.http;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class BrowserHttp {

  public void Test() {
    System.out.print("http test");
    try {
      URL u = new URL("http://baidu.com");
      URLConnection conn = u.openConnection();
      HttpURLConnection HttpConn = (HttpURLConnection) conn;
      HttpConn.setRequestMethod("GET");
      HttpConn.setConnectTimeout(2000); // 单位毫秒,这里设置了两秒
      HttpConn.setReadTimeout(60000); // 响应 60秒超时
      HttpConn.setDoInput(true); // 获取返回值
      HttpConn.setDoOutput(true); // 输出s
      try {
        HttpConn.connect();
        System.out.println("已连接成功");
        // 读取返回Headers
        Map<String, List<String>> ResponseHeaders = conn.getHeaderFields();
        // System.out.println(ResponseHeaders); //打印当前链接
        Set<String> Keys = ResponseHeaders.keySet();
        for (Map.Entry<String, List<String>> entry : ResponseHeaders.entrySet()) {
          String K = entry.getKey();
          if (K != null) {
            System.out.printf("%s=", K.toString());
          }
          System.out.println(entry.getValue().toArray()[0]);
        }
        // 读取返回值
        String ConnType = conn.getContentType();
        System.out.println(ConnType);

      } catch (Exception ioe) {
        System.out.println(ioe.toString());
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
}
