package base.date;

import base.obj.Str;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Date 时间
// SimpleDateFormat 时间格式化处理
// Calendar GregorianCalendar 时间计算
public class Descr {
    public static void main(String[] args) {
        now();
        trans();
        compare();
    }

    /**
     * 获取当前时间
     */
    public static void now() {
        Date data = new Date();
        long timestamp = data.getTime();
        long timestamp1 = System.currentTimeMillis();
        System.out.printf("当前时间戳：%d %d \n", timestamp, timestamp1);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dateStr = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        System.out.printf("当前时间：%s \n", dateStr);
    }

    /**
     * 相互转化
     */
    public static void trans() {
        // 解析时间并转时间戳
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //设置日期格式 HH:MM:SS PM 为12小时制
        String dateStr = "2022-12-05 11:02";
        Date date = new Date();
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            System.out.printf("parse date err：%s \n", dateStr);
        }
        System.out.printf("解析 %s 并转时间戳成功：%d \n", dateStr, date.getTime());

        // 时间戳转时间
        long timestamp = 1670209320000L;
        Date date1 = new Date(timestamp);
        System.out.printf("%d 转化为时间：%s \n", timestamp, df.format(date1));
    }

    public static void compare() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateStr1 = "2022-10-12 11:12";
        String dateStr2 = "2022-10-13 12:13";
        try {
            Date date1 = df.parse(dateStr1);
            Date date2 = df.parse(dateStr2);
            System.out.printf("%s 与 %s 比较：%d \n", dateStr1, dateStr2, date1.compareTo(date2));
            System.out.printf("%s 与 %s 相差天数：%.1f \n", dateStr1, dateStr2, Math.floor((date2.getTime() - date1.getTime())/86400000));
        } catch (ParseException e) {
            System.out.printf("parse date err：%s \n", e.getMessage());
        }
    }
}
