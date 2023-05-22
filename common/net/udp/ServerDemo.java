package common.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerDemo {
    public static int clientPort = 91;
    public static int serverPort = 92;
    public static void main(String[] args) {
        try (DatagramSocket server = new DatagramSocket(serverPort)) {
            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
            server.receive(packet);
            System.out.printf("%s:%d %s \n", packet.getAddress().getHostName(), packet.getPort(), new String(packet.getData()));
            packet.setData("Hello Client".getBytes());
            packet.setPort(clientPort);
            packet.setAddress(InetAddress.getLocalHost());
            server.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
