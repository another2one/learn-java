package base.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

// OutputStream  inputStream 字节流(二进制格式读取)
// Reader  Writer 字符流(会按指定编码读取)
public class fileDescr {
    private static final String path = "D:/app/java/learn-java/base/io/test/";
    public static void main(String[] args) throws IOException {
        String fileName = path + "test.txt";
        deleteFolder(new File(path));
        scan(fileName);
        readWriter(fileName, path + "writer.txt");
        stream(fileName, path + "stream.txt");
        bufferCopy(fileName, path + "buffer.txt");
//        scanDir(Paths.get(path).getParent().getParent().getParent().toString(), 3);
    }

    public static void scan(String fileName) throws IOException {
        // TODO: 为何 q 无效
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 退出。");
        String c = "";
        StringBuilder sb = new StringBuilder();
        // 读取字符
        while (true) {
            try {
                c = br.readLine();
                if (c.equals("q")) {
                    break;
                }
                System.out.println(c);
                sb.append(c + "\r\n");
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

        };

        getFile(fileName);
        // 写入文件
        Path path = Paths.get(fileName);
        // 使用newBufferedWriter创建文件并写文件
        // 这里使用了try-with-resources方法来关闭流，不用手动关闭
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 检查文件是否存在 不存在就创建
     * @param fileName 路径
     * @return 是否存在
     */
    public static File getFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            // 先检查目录
            String path = file.getParent();
            File pathFile = new File(path);
            if (!pathFile.exists()) {
                pathFile.mkdirs();
            }
            file.createNewFile(); // 能创建多级目录
        }
        return file;
    }

    public static void readWriter(String from, String to) {
        // 这种结构会自动写入关闭文件
        try (Scanner scanner = new Scanner(getFile(from));
             FileWriter writer = new FileWriter(to, true)) { // 会自动创建文件 true表示追加写入
            while (scanner.hasNext()) {
                writer.write(scanner.nextLine() + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("%s \n", "readWriter ...");
    }

    public static void stream(String from, String to) {
        try {
            // 读取 这里优化为一段段读取
            FileInputStream fip = new FileInputStream(getFile(from));
            InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
            StringBuffer sb = new StringBuffer();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
            reader.close();
            fip.close();

            // 写入
            FileOutputStream fop = new FileOutputStream(getFile(to), true);
            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");

            writer.append(sb);
            writer.close();
            fop.close();
        } catch (IOException e) {
            System.out.printf("%s \n", e.getMessage());
        }
        System.out.printf("%s \n", "stream ...");
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

    /**
     * 删除文件及目录
     * @param folder
     */
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

    public static void bufferCopy(String from, String to) throws IOException {
        File sourceFile = getFile(to);
        File copyFile = getFile(from);
        FileInputStream fileInputStream = new FileInputStream(copyFile);// 从文件中读数据
        FileOutputStream fileOutputStream = new FileOutputStream(sourceFile, true);// 用于把数据写入文件
        try {
            byte b[] = new byte[8192];
            int len = b.length;
            while ((len = fileInputStream.read(b, 0, len)) > 0) {
                fileOutputStream.write(b, 0, len);
            }
            fileOutputStream.flush();

            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("%s \n", "bufferCopy ...");
    }
}
