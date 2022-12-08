package datastruct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

// hasNext next remove
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        numbers.sort(Comparator.naturalOrder()); // Comparator.reverseOrder() 倒序
        Iterator i = numbers.iterator();
        while (i.hasNext()) {
            System.out.printf("%d \n", i.next());
        }
    }
}
