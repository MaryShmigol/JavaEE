package Task1;

import java.util.ArrayList;

public class MyMethod {

    @MyAnnotation(value1 = 2, value2 = 5)
    public static void getNumber(int a, int b) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }
        System.out.println(arr.get(a));
        System.out.println(arr.get(b));
    }
}