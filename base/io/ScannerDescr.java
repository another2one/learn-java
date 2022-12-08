package base.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerDescr {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            System.out.printf("读取到的：%s \n", scan.nextLine());
        }
        scan.close();

        try (Scanner scanner = new Scanner(new File("D:\\java\\learn-java\\base\\io\\test\\test.txt"));
            PrintWriter writer = new PrintWriter("D:\\java\\learn-java\\base\\io\\test\\test.txt")) { // 会自动创建文件
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine() + "\r\n");
            }
        }

//        Console cons = System.console();
//        if (cons !=  null)  {
//            System.out.printf("Console is available. \n");
//        } else {
//            System.out.printf("Console is not available. \n");
//            return;
//        }
    }
}
