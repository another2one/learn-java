package util;

import java.util.List;

public class ArrayHelper {
    public static <T> T getWithDefault(T[] arr, int index, T defaultValue) {
        return arr.length > index ? arr[index] : defaultValue;
    }
}
