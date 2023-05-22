package base.type;

// https://www.runoob.com/java/java-basic-datatypes.html
// 内置数据类型
// byte     8位     -128-127     默认0
// short     16位     -2^15-2^15-1     默认0
// int     32位      -2^31-2^31-1     默认0
// long     64位     -2^63-2^63-1     默认0L
// float    32位     默认0.0f
// double    64位     默认0.0d
// boolean    1位      true/false      默认false
// char    16位      \u0000-\uffff 0-2^15-1    默认'\u0000' 如: char a = 'A'
// wtf 首字母大写就会变成对象类型  整数的默认类型是int 小数默认是double
//
// 引用类型
// 在Java中，引用类型的变量非常类似于C/C++的指针。引用类型指向一个对象，指向对象的变量是引用变量。这些变量在声明时被指定为一个特定的类型，比如 Employee、Puppy 等。变量一旦声明后，类型就不能被改变了。
// 对象、数组都是引用数据类型。
// 所有引用类型的默认值都是null。
// 一个引用变量可以用来引用任何与之兼容的类型。
public class Number {

    final static double PI = 3.1415927; // 常量

    static int s = 1;
    
    public static void main(String[] args) {
         maxValue();
         calc();
    }

    /**
     * 溢出
     */
    public static void maxValue() {
        byte b = (byte) (Byte.MAX_VALUE + 1);
        System.out.printf("byte 最大值 %d, 最大值加1 %d, 二进制为 %s \n", 
            Byte.MAX_VALUE,
            b,
            Integer.toBinaryString(Byte.MAX_VALUE + 1)
        );
    }

    public static void calc() {
        // 自动类型转换
        // 低  ------------------------------------>  高
        //byte,short,char—> int —> long—> float —> double
        byte a = 1;
        float b = a + 1;
        int c = (int)b + 1; // 强制转换 会丢失精度
        System.out.printf("%d, %.1f, %d", a, b, c);
        // byte,short,char 一旦参与计算就会变成 int 类型
//        a = a+1; // 会报错

    }
}