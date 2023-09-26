package common.net.http.httpserver;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Http {
    public static void main(String[] args) throws IOException {

        int port = 8080;
        //创建一个HttpServer实例，并绑定到指定的IP地址和端口号
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(port), 0);

        //创建一个HttpContext，将路径为/myserver请求映射到MyHttpHandler处理器
        httpServer.createContext("/myserver", new MyHttpHandler());

        //设置服务器的线程池对象
        httpServer.setExecutor(Executors.newFixedThreadPool(10));

        System.out.printf("http://127.0.0.1:%d/myserver \n", port);
        //启动服务器
        httpServer.start();
    }
}