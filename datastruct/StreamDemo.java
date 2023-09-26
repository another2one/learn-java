package datastruct;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 流式处理
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.printf("%s \n", filtered);
    }
}
