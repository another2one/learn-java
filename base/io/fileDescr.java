package base.io;

import java.io.*;
import java.util.Scanner;

public class fileDescr {
    public static void main(String[] args) {
//        ioRead();
        fileRead();
        file();
        scanDir("D:\\java\\learn-java\\base", 3);
    }

    public static void fileRead() {
        // 这种结构会自动写入关闭文件
        try (Scanner scanner = new Scanner(new File("D:\\java\\learn-java\\base\\io\\test\\test.txt"));
             FileWriter writer = new FileWriter("D:\\java\\learn-java\\base\\io\\test\\testRead.txt", true)) { // 会自动创建文件 true表示追加写入
            while (scanner.hasNext()) {
                writer.write(scanner.nextLine() + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ioRead() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        String c;
        // 读取字符
        do {
            try {
                c = br.readLine();
            } catch (IOException e) {
                System.out.printf("%s \n", e.getMessage());
                break;
            }
            System.out.println(c);
        } while (c.equals("q"));
    }

    public static void file() {
        String path = "D:\\java\\learn-java\\base\\io\\test";
        java.io.File f = new java.io.File(path);
        if (!f.isDirectory() && !f.mkdirs()) {
            System.out.printf("创建 %s 目录失败 \n", path);
            return;
        }
        f = new java.io.File(path + "\\test.txt");
        try {
            // 写入
            FileOutputStream fop = new FileOutputStream(f, true);
            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
            writer.append("\r\n中文输入");
            writer.close();
            fop.close();

            // 读取 这里优化为一段段读取
            FileInputStream fip = new FileInputStream(f);
            InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
            StringBuffer sb = new StringBuffer();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            System.out.println(sb.toString());
            reader.close();
            fip.close();
        } catch (IOException e) {
            System.out.printf("%s \n", e.getMessage());
        }
    }

    public static void scanDir(String path, int level) {
        if (level <= 0) {
            return;
        }
        java.io.File f1 = new java.io.File(path);
        String pre = "--";
        for (int i = level; i < 3; i++) {
            pre = pre.concat("--");
        }
        if (f1.isDirectory()) {
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++) {
                java.io.File f = new java.io.File(path + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(pre + ">" + s[i]);
                    scanDir(f.getPath(), level-1); // 不能 level-- 不然 level 跟着变
                } else {
                    System.out.println(pre + s[i]);
                }
            }
        } else {
            System.out.println(path + " 不是一个目录");
        }
    }

    // 删除文件及目录
    public static void deleteFolder(java.io.File folder) {
        java.io.File[] files = folder.listFiles();
        if (files != null) {
            for (java.io.File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    public static void copy(String[] args) {
        java.io.File sourcefile = new java.io.File("./test/test.txt");
        java.io.File copyfile = new java.io.File("./test/testcopy.txt");
        FileInputStream fileInputStream = null;// 从文件中读数据
        FileOutputStream fileOutputStream = null;// 用于把数据写入文件
        BufferedWriter bufferedWriter = null;// 用于把数据写入文件
        try {
            if (!sourcefile.exists()) {
                sourcefile.createNewFile();
                bufferedWriter = new BufferedWriter(new FileWriter(sourcefile));
                // bufferedwriter 自动追加数据
                String s = new String(" I love Java");

                char bchar[] = s.toCharArray();
                for (int i = 0; i < 5; i++) {
                    // 两种方式往文件中写数据
                    bufferedWriter.write(bchar, 0, bchar.length);
                    bufferedWriter.write(", " + s + "\n");
                }
                // 写完之后才能关闭流,
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            copyfile.createNewFile();
            fileInputStream = new FileInputStream(sourcefile);
            fileOutputStream = new FileOutputStream(copyfile);
            byte b[] = new byte[8192];
            int len = b.length;
            while ((len = fileInputStream.read(b, 0, len)) > 0) {
                fileOutputStream.write(b, 0, len);
                fileOutputStream.flush();
            }
            System.out.println("file copied");
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
