package base.calc;

public class Descr {
    
    // 算术运算符  + - * / ^ ++ -- 

    // 关系运算符 == != > < >= <=

    // 位运算符 &(都为1则为1) |(都为0则为0) ~(全部取反) ^(相同为1) << >> >>>
    // A = 0011 1100
    // B = 0000 1101
    // -----------------
    // A&B = 0000 1100
    // A | B = 0011 1101
    // A ^ B = 0011 0001
    // ~A= 1100 0011
    // A<<2 1111 0000
    // A>>2 0000 1111
    // A>>>2 0000 1111
   

    // 逻辑运算符 && || ！

    // 赋值运算符 += ......

    // 其他运算符  ?： instanceof

    public static void main(String[] args) {
        int a = Integer.valueOf("00111100", 2);
        a = a>>2;
        System.out.printf("00111100 >> 2 = %s \n", Integer.toBinaryString(a));

        a = Integer.valueOf("00111100", 2);
        a = a>>>2;
        System.out.printf("00111100 >>> 2 = %s \n", Integer.toBinaryString(a));

        int b = Integer.valueOf("11001100", 2);
        b = b>>2;
        System.out.printf("11001100 >> 2 %s \n", Integer.toBinaryString(b));

        b = Integer.valueOf("11001100", 2);
        b = b>>>2;
        System.out.printf("11001100 >>> 2 %s \n", Integer.toBinaryString(b));
    }
}
