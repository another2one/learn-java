package util;

import java.io.File;
import java.io.IOException;

public class FileHelper {
    public static Boolean checkPath(String path) {
        File p = new File(path);
        if (!p.isDirectory()) {
            return p.mkdirs();
        }
        return true;
    }

    public static Boolean checkFile(String filename) throws IOException {
        File p = new File(filename);
        if (p.exists()) {
            return true;
        }
        // 检查创建目录
        if (checkPath(p.getParent())) {
            return p.createNewFile();
        }
        return true;
    }
}
