package util;

import java.util.List;

public class ListHelper {
    public static <T> T getWithDefault(List<T> list, int index, T defaultValue) {
        return list.size() > index ? list.get(index) : defaultValue;
    }
}
