package common.serialize;

import util.Define;
import util.FileHelper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {
    public static void main(String[] args) throws IOException {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        String filename = Define.APP_PATH + "common\\serialize\\data\\employee.txt";
        if (!FileHelper.checkFile(filename)) {
            System.out.printf("create file error \n");
            return;
        }
        Path serFile = Paths.get(filename);

        // 序列化
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(serFile))) {
            out.writeObject(e);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // 反序列化
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(serFile))) {
            e = (Employee) in.readObject();
            e.mailCheck();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
