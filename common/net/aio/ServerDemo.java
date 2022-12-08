package common.net.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * java -classpath D:\java\learn-java\out\production\learn-java common.net.aio.ServerDemo
 * AIO: async-non-blocking IO 异步非阻塞 订阅通知模式 应用向操作系统注册 io 事件，应用可以做其他事，由操作系统通知应用程序
 * windows异步IO技术：IOCP（I/O CompletionPort，I/O完成端口）
 * Linux下由于没有这种异步IO技术，所以使用的是epoll（上文介绍过的一种多路复用IO技术的实现）对异步IO进行模拟
 */
public class ServerDemo {
    public AsynchronousServerSocketChannel serverSocketChannel;

    public void listen() throws Exception {
        // 打开一个服务端通道
        serverSocketChannel = AsynchronousServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(90));// 监听9988端口
        // 监听
        serverSocketChannel.accept(this, new CompletionHandler<AsynchronousSocketChannel, ServerDemo>() {
            @Override
            public void completed(AsynchronousSocketChannel client, ServerDemo attachment) {
                try {
                    if (client.isOpen()) {
                        System.out.println("new client: " + client.getRemoteAddress());
                        final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        // 读取客户端发送的数据
                        client.read(byteBuffer, client, new CompletionHandler<Integer, AsynchronousSocketChannel>() {
                            @Override
                            public void completed(Integer result, AsynchronousSocketChannel attachment) {
                                try {
                                    // 输出服务端响应发送过来的消息
                                    String msg = new String(byteBuffer.array()).trim();
                                    System.out.println("client msg: " + msg);
                                    // 向客户端发送数据
                                    attachment.write(ByteBuffer.wrap("Hello,client \n".getBytes()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
                                try {
                                    exc.printStackTrace();
                                    attachment.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 当有新的客户端接入的时候，直接调用accept的方法，递归执行下去，这样可以保证多个客户端都可以阻塞
                    attachment.serverSocketChannel.accept(attachment, this);
                }
            }

            @Override
            public void failed(Throwable exc, ServerDemo attachment) {
                exc.printStackTrace();
            }
        });
    }


    public static void main(String[] args) throws Exception {
        new ServerDemo().listen();
        Thread.sleep(Integer.MAX_VALUE);
    }
}