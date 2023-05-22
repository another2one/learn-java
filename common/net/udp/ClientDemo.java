package common.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientDemo {
    public static void main(String[] args) {
        try (DatagramSocket client = new DatagramSocket(ServerDemo.clientPort)) {
            DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
            packet.setPort(ServerDemo.serverPort);
            packet.setAddress(InetAddress.getLocalHost());
            packet.setData("Hello Server".getBytes());
            client.send(packet);
            client.receive(packet);
            System.out.printf("%s:%d %s \n", packet.getAddress().getHostName(), packet.getPort(), new String(packet.getData()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
