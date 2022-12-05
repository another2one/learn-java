package base.type;

public class Format {
    public static void main(String[] args) {
        // 数字输出 %d %o %x %#x %u %f %c %t(时间)
        System.out.printf("%c, 1001011 = %d, 75 转为二进制 %s \n", 68, Integer.valueOf("1001011", 2), Integer.toBinaryString(75));
        // 输出样式 %md %-md %m.nf m为输出的最小宽度默认不足时左端补空格，为负数代表右端补空格
        System.out.printf("%-10s, %10s, %10s, %2.2f \n", "123", "123", "123456789123456789", 123.123f);
    }
}
