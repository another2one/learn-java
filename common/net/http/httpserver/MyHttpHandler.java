package common.net.http.httpserver;

import com.alibaba.fastjson2.JSON;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 处理/myserver路径请求的处理器类
 */
public class MyHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) {
        try {
            Demo demo = Demo.instance();
            demo.level+= 10;
            StringBuilder responseText = new StringBuilder();
            responseText.append("method:").append(demo.level++).append(httpExchange.getRequestMethod()).append("<br/>");
            responseText.append("请求参数：").append(getRequestParam(httpExchange)).append("<br/>");
            responseText.append("请求头：<br/>").append(getRequestHeader(httpExchange));
//            handleHtmlResponse(httpExchange, responseText.toString());
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("name", "李志");
            handleJsonResponse(httpExchange, map);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取请求头
     * @param httpExchange
     * @return
     */
    private String getRequestHeader(HttpExchange httpExchange) {
        Headers headers = httpExchange.getRequestHeaders();
        return headers.entrySet().stream()
                .map((Map.Entry<String, List<String>> entry) -> entry.getKey() + ":" + entry.getValue().toString())
                .collect(Collectors.joining("<br/>"));
    }

    /**
     * 获取请求参数
     * @param httpExchange
     * @return
     * @throws Exception
     */
    private String getRequestParam(HttpExchange httpExchange) throws Exception {
        String paramStr = "";

        if (httpExchange.getRequestMethod().equals("GET")) {
            //GET请求读queryString
            paramStr = httpExchange.getRequestURI().getQuery();
        } else {
            //非GET请求读请求体
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody(), "utf-8"));
            StringBuilder requestBodyContent = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                requestBodyContent.append(line);
            }
            paramStr = requestBodyContent.toString();
        }

        return paramStr;
    }

    /**
     * 处理响应
     * @param httpExchange
     * @param responsetext
     * @throws Exception
     */
    private void handleHtmlResponse(HttpExchange httpExchange, String responsetext) throws Exception {
        //生成html
        StringBuilder responseContent = new StringBuilder();
        responseContent.append("<html>")
                .append("<body>")
                .append(responsetext)
                .append("</body>")
                .append("</html>");
        String responseContentStr = responseContent.toString();
        byte[] responseContentByte = responseContentStr.getBytes("utf-8");

        //设置响应头，必须在sendResponseHeaders方法之前设置！
        httpExchange.getResponseHeaders().set("Content-Type", "text/html;charset=utf-8");

        //设置响应码和响应体长度，必须在getResponseBody方法之前调用！
        httpExchange.sendResponseHeaders(200, responseContentByte.length);

        OutputStream out = httpExchange.getResponseBody();
        out.write(responseContentByte);
        out.flush();
        out.close();
    }

    /**
     * @param t
     * @param hashMap
     * @throws Exception
     */
    private void handleJsonResponse(HttpExchange t, HashMap<String, String> hashMap) throws Exception {
        String response = JSON.toJSONString(hashMap);
        byte[] responseContentByte = response.getBytes("utf-8");
        t.getResponseHeaders().set("Content-Type", "application/json");
        t.sendResponseHeaders(200, responseContentByte.length);
        OutputStream os = t.getResponseBody();
        os.write(responseContentByte);
        os.close();
    }
}
