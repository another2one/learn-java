package common.net.bio;

import util.ArrayHelper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java -classpath D:\java\learn-java\out\production\learn-java common.net.bio.ServerDemo
 * BIO: Blocking IO 同步阻塞 一个请求对应一个线程 每个线程阻塞 accept 等待请求
 */
public class ServerDemo {
    public static ExecutorService executorService = Executors.newCachedThreadPool();

    public static final String DEFAULT_PORT = "88";

    public static void main(String[] args) {
        int port = Integer.parseInt(ArrayHelper.getWithDefault(args, 0, DEFAULT_PORT));
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(100000);
            System.out.printf("127.0.0.1:%d start success! \n", port);
            run(serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run(ServerSocket serverSocket) {
        try {
            while (true) {
                System.out.print("wait accept... \n");
                Socket s = serverSocket.accept();
                System.out.printf("accept %s msg \n", s.getInetAddress().getHostAddress());

                executorService.execute(() -> {
                    try {
                        readAndWriteMsg(s.getInputStream(), s.getOutputStream());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取和写入消息
     *
     * @throws IOException
     */
    public static void readAndWriteMsg(InputStream ins, OutputStream outs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
        while (true) {
            String msg = br.readLine();
            System.out.printf("client msg: %s \n", msg);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outs));
            bw.write(msg + "\n");
            bw.flush();
        }
    }
}