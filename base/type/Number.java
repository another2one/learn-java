package base.type;

// https://www.runoob.com/java/java-basic-datatypes.html
// byte     8位     -128-127     默认0
// short     16位     -2^15-2^15-1     默认0
// int     32位      -2^31-2^31-1     默认0
// long     64位     -2^63-2^63-1     默认0L
// float    32位     默认0.0f
// double    64位     默认0.0d
// boolean    1位      true/false      默认false
// char    16位      \u0000-\uffff     默认'\u0000' 如: char a = 'A'
// wtf 首字母大写就会变成对象类型  整数的默认类型是int 小数默认是double
public class Number {

    final double PI = 3.1415927; // 常量
    
    public static void main(String[] args) {
         maxValue();
    }

    /**
     * 溢出
     */
    public static void maxValue() {
        System.out.printf("byte 最大值 %d, 最大值加1 %d, 二进制为 %s \n", 
            Integer.MAX_VALUE, 
            Integer.MAX_VALUE + 1, 
            Integer.toBinaryString(Integer.MAX_VALUE + 1)
        );
    }
}