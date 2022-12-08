package common.net.bio;

import util.ArrayHelper;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

// java -classpath D:\java\learn-java\out\production\learn-java common.net.bio.ClientDemo
public class ClientDemo {
    public static void main(String[] args) {
        String serverName = "127.0.0.1";
        int port = Integer.parseInt(ArrayHelper.getWithDefault(args, 0, ServerDemo.DEFAULT_PORT));
        try (Socket client = new Socket(serverName, port)) {
            System.out.printf("%s:%d start success! \n", serverName, port);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader brs = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

            while (true) {
                // 控制台发送消息
                String s = brs.readLine();
                if (s.equals("quit")) {
                    break;
                }
                bw.write(s + "\n");
                bw.flush();

                // 等待服务端回复
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.printf("server msg: %s \n", br.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
