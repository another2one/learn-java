package datastruct.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.runoob.com/java/java-data-structures.html
// 通过 hashMap 实现 实际时就是map键
public class init {
    public static void main(String[] args) {
        // 1
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("g", "good");
        System.out.printf("%s \n", map);

        // 2
        map = batchAdd("a", "abandon", "b", "bar", "c", "cao");
        System.out.printf("%s \n", map);

        // 3
        Map<String, Integer> map1 = Stream.of(
                new Object[][]{{"data1", 1}, {"data2", 2},}
        ).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
        HashMap<String, Integer> hashMap1 = new HashMap<>(map1); // map 转 hashmap
        System.out.printf("%s \t %s\n", map1, hashMap1);

        // 4
        Map<String, Integer> map2 = Stream.of(
                new Object[][]{{"data3", 3}, {"data4", 4},}
        ).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));
        HashMap<String, Integer> hashMap2 = map2.entrySet().stream().collect(
                Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, HashMap::new
                )
        ); // map 转 hashmap
        System.out.printf("%s \t %s\n", map2, hashMap2);
    }

    /**
     * 初始化 Hashmap
     * TODO: 如何生成不同类型的键值对 参考 java9 的 Map.of
     * @param ? v
     * @return HashMap<K, K>
     */
    public static <K> HashMap<K, K> batchAdd(K ... v) {
        HashMap<K, K> map = new HashMap<K, K>();
        for (int i = 0; i + 1 < v.length; i += 2) {
            map.put(v[i], v[i + 1]);
        }
        return map;
    }
}
