package util;

import java.util.HashMap;

public class CommonHelper {

    public static HashMap<String, Long> timeMap = new HashMap<String, Long>();

    /**
     * tag 必须成对出现
     * @param tag 标记
     */
    public static void timeSpend(String tag) {
        String s = tag + "_start";
        if (timeMap.get(s) == null) {
            timeMap.put(s, System.currentTimeMillis());
        } else {
            System.out.printf("%s 共花费 %d ms \n", tag, System.currentTimeMillis() - timeMap.get(s));
        }
    }
}
