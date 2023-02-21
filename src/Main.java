import lists.IntList;
import lists.IntListImpl;
import lists.StringListImpl;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        IntList intList1 = new IntListImpl();
        IntList intList2 = new IntListImpl();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            intList1.add(random.nextInt(100));
        }

        for (int i = 0; i < 20; i++) {
            intList2.add(random.nextInt(50));
        }


        System.out.println("Несортированный список intList1:");
        System.out.println(Arrays.toString(intList1.toArray()));

        System.out.println("Отсортированный список intList1:");
        intList1.bubbleSort();
        System.out.println(Arrays.toString(intList1.toArray()));

        System.out.println();
        System.out.println("Несортированный список intList2:");
        System.out.println(Arrays.toString(intList2.toArray()));

        Integer integer1;
        Integer integer2 = random.nextInt(50);
        try {
            integer1 = intList2.get(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("Результат поиска элемента " + integer1 + " в списке intList2");
        System.out.println(intList2.contains(integer1));
        System.out.println("Результат поиска элемента " + integer2 + " в списке intList2");
        System.out.println(intList2.contains(integer2));

        System.out.println();
        System.out.println("Отсортированный список intList2 (быстрая сортировка):");
        intList2.quickSort();
        System.out.println(Arrays.toString(intList2.toArray()));
    }
}