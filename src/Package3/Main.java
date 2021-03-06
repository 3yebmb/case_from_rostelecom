package Package3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Object[] intArr = {null, 1, 2, null, 7, 1, 2};

        System.out.println("Исходный массив : " + Arrays.toString(intArr));

        intArr = method1(intArr);
        System.out.println("Массив без повторяющиъся элементов 1 метод : " + Arrays.toString(intArr));
        intArr = method2(intArr);
        System.out.println("Массив без повторяющиъся элементов 2 метод : " + Arrays.toString(intArr));
    }

    private static Object[] method1(Object[] arr1) {
        HashSet<Object> hs = new HashSet<>();

        for (Object o : arr1) {
            if (hs.contains(o)) hs.remove(o);
            else hs.add(o);
        }

        return hs.toArray();
    }

    private static <T> T[] method2(T[] arr2) {
        boolean isNull = false;
        ArrayList<T> al = new ArrayList<>(Arrays.asList(arr2));
        int lenArr = 0;

        for (int i = 0; i < arr2.length; i++) {
            lenArr = al.size();
            if ((arr2[i] == null)) isNull = true;
            else isNull = false;

            for (int j = i+1; j < arr2.length; j++) {
                if (isNull) {
                    if (arr2[j] == null) {
                        al.remove(j);
                    }
                } else {
                    if (arr2[i].equals(arr2[j]))
                        al.remove(arr2[j]);
                }
            }
            if (lenArr != al.size()) al.remove(arr2[i]);
        }

        return (T[]) al.toArray();

    }
}
