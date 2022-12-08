package base.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

// https://zhuanlan.zhihu.com/p/27824934
/**
 * 实际上就是编译器在 finally 帮你生成代码依次调用 try 里面打开资源的 close()
 *
 * public class TryWithResource {
 *     public TryWithResource() {
 *     }
 *     public static void main(String[] args) {
 *         try {
 *             Connection e = new Connection();
 *             Throwable var2 = null;
 *             try {
 *                 e.sendData();
 *             } catch (Throwable var12) {
 *                 var2 = var12;
 *                 throw var12;
 *             } finally {
 *                 // 这里面就是调用逻辑 实际时帮你调用了 close() 方法关闭资源
 *                 // 但是要注意 try 里面 close 的逻辑
 *                 if(e != null) {
 *                     if(var2 != null) {
 *                         try {
 *                             e.close();
 *                         } catch (Throwable var11) {
 *                             var2.addSuppressed(var11); // 将一个异常附加到另一个异常身上，从而避免异常屏蔽
 *                         }
 *                     } else {
 *                         e.close();
 *                     }
 *                 }
 *             }
 *         } catch (Exception var14) {
 *             var14.printStackTrace();
 *         }
 *     }
 * }
 */
public class Descr {
    public static void main(String[] args) {
        // 会分分别调用 fin fout out 的 close
        // GZIPOutputStream 会先写入最好的信息再关闭 fout 如果发生异常会导致关闭失败 所以最好单独分出 FileOutputStream
        try (FileInputStream fin = new FileInputStream(new File("input.txt"));
             FileOutputStream fout = new FileOutputStream(new File("out.txt"));
             GZIPOutputStream out = new GZIPOutputStream(fout)) {
            byte[] buffer = new byte[4096];
            int read;
            while ((read = fin.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
