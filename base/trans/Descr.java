package base.trans;

import java.util.Arrays;

// 类型转换
public class Descr {

    final double PI = 3.1415927; // 常量
    
    public static void main(String[] args) {
         numberAndNumber();
         numberAndString();
         numberAndChar();
         charAndString();
         bytesAndString();
    }

    public static void numberAndNumber() {
        // 基本类型转换
        // 低  ------------------------------------>  高
        // byte,short,char—> int —> long—> float —> double 
        // 1. boolean 不能转换
        // 2. 不能把对象类型转换成不相关类的对象
        // 3. 在把容量大的类型转换为容量小的类型时必须使用强制类型转换
        // 4. 转换过程中可能导致溢出或损失精度
        // 5. 浮点数到整数的转换是通过舍弃小数得到，而不是四舍五入
        int i = 128;
        long l = i;
        byte b = (byte)i; // 溢出
        System.out.printf("b = %d, (int)-45.89f == %d, l = %d \n", b, (int)-45.89f, l);
    }

    public static void numberAndString() {
        // 字符串转数字 Integer.parseInt(String str)  Integer.valueOf(String str).intValue()
        // 数字转字符串 String.valueOf(int i)   Integer.toString(int i)  String.format    ""+i
        // 小数转整数 (int)-45.89f  new Double(d1).intValue(); Math.floor(-11.2)
        System.out.printf("字符串1转小数=%f, 小数转字符串%s, 小数1.71转整数%d, 小数1.71取整%d \n", 
            Float.parseFloat("1"), 
            String.format("%s", 1.01), 
            Double.valueOf(1.71).intValue(),
            Math.round(1.71) // ceil floor
        );
    }

    public static void bytesAndString() {
        byte[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
        String helloString = new String(helloArray);
        helloArray = helloString.getBytes();
        System.out.println("--- bytesAndString ---");
        System.out.println(helloString);
        System.out.println(Arrays.toString(helloArray));
    }

    public static void charAndString() {
        char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
        String helloString = new String(helloArray);
        helloArray = helloString.toCharArray();
        System.out.println( helloString );
    }

    public static void numberAndChar() {
        // char 底层还是number 只是对应asci码
        char a = 'A';
        int i = a;
        char c = (char)i;
        System.out.printf("i=%d, c=%c \n", i, c);
    }
}