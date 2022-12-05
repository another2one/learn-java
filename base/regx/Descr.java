package base.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 正则表达式 两个 \\ 代表其他语言中的一个 \
public class Descr {

    public static void main(String[] args) {
        String content = "I am noob from runoob.com or li.cn";

        // 匹配
        String pattern = ".*\\snoob\\s.*";
        System.out.printf("'%s' 是否包含 '%s' : %b \n", content, pattern, Pattern.matches(pattern, content));

        // 查找
        String pattern2 = "((\\w+)\\.(\\w+))";
        Pattern r = Pattern.compile(pattern2);
        Matcher m = r.matcher(content);
        int i = 0;
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            i++;
            System.out.printf("%s 匹配到的第%d个:(0)%s (1)%s (2)%s (3)%s \n", pattern2, i, m.group(0), m.group(1), m.group(2), m.group(3));
            if (i == 2) {
                m.appendReplacement(sb, "taobao.com");
            }
        }
        m.appendTail(sb);
        System.out.printf("替换第二个匹配到：%s \n", sb.toString());

        // 替换
        String s = m.replaceAll("baidu.com");
        System.out.printf("替换全部匹配到:%s \n", s);
    }
}
