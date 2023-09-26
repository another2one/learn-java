package datastruct.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// https://www.runoob.com/java/java-data-structures.html
// 通过 hashMap 实现 实际时就是map键
public class iterator {
    public static void main(String[] args) {
        HashMap<String, String> map = init.batchAdd("a", "abandon", "b", "bar", "c", "cao");
        foreach(map);
    }

    public static <K, V> void foreach(Map<K, V> map) {
        // 1
        for (K key : map.keySet()) {
            System.out.printf("%s => %s \n", key, map.get(key));
        }
        // 2
        for (Map.Entry<K, V> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
            System.out.printf("%s => %s \n", entry.getKey(), entry.getValue());
        }
        // 3
        Iterator<K> iterator = map.keySet().iterator();
        K key;
        while (iterator.hasNext()) {
            key = iterator.next();
            System.out.printf("%s => %s \n", key, map.get(key));
        }
        // 4
        Iterator<Map.Entry<K, V>> iterator1 = map.entrySet().iterator();
        Map.Entry<K, V> entry;
        while (iterator1.hasNext()) {
            entry = iterator1.next();
            System.out.printf("%s => %s \n", entry.getKey(), entry.getValue());
        }
        // 5
        map.forEach((k, v) -> System.out.printf("%s %s\n", k, v));
    }
}
