package common.net.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

// java -classpath D:\java\learn-java\out\production\learn-java common.net.aio.ClientDemo
public class ClientDemo {
    public static void main(String[] args) throws InterruptedException, IOException {
        // 打开一个客户端通道
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
        // 与服务端建立连接
        channel.connect(new InetSocketAddress("127.0.0.1", 90));
        // 睡眠一秒，等待与服务端的连接
        Thread.sleep(1000);

        // 向服务端发送数据
        channel.write(ByteBuffer.wrap("Hello,server".getBytes()));

        Thread.sleep(1000);
        // 从通道读取数据到缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        // 输出服务端响应发送过来的消息
        String msg = new String(buffer.array()).trim();
        System.out.println("server msg: " + msg);
    }
}
