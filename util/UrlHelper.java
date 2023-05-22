package util;


import com.alibaba.fastjson2.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlHelper {
    public static String curlGet(String urlStr) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection();
            if (!(urlConnection instanceof HttpURLConnection)) {
                throw new IllegalArgumentException("非http请求");
            }
            HttpURLConnection c = (HttpURLConnection) urlConnection;
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String s;
            while ((s = br.readLine())!= null) {
                stringBuilder.append(s);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    public static String post(String url, JSONObject param) throws Exception{
        StringBuffer sb = new StringBuffer();
        try {
            URL newUrl =new URL(url);
            HttpURLConnection conn = (HttpURLConnection) newUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("content-type","application/json;charset=utf-8");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStream out = conn.getOutputStream();
            out.write(param.toString().getBytes());
            int code = conn.getResponseCode();
            if(code == 200){
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String len;
                while((len=reader.readLine())!=null){
                    len = new String(len.getBytes(),"utf-8");
                    sb.append(len);
                }
                reader.close();
                conn.disconnect();
            }
            System.out.println("return original result:"+sb.toString());
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
