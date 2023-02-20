import lists.IntList;
import lists.IntListImpl;
import lists.StringListImpl;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*StringListImpl list1 = new StringListImpl(5);
        StringListImpl list2 = new StringListImpl();

        System.out.println("Длины списков:");
        System.out.println("list1:" + list1.size());
        System.out.println("list2:" + list2.size());

        for (int i = 0; i < 10; i++) {
            list1.add(Integer.toString(i));
        }

        list2.add("aaa");
        list2.add("bbb");
        list2.add("ccc");
        list2.add("ddd");
        list2.add("eee");

        System.out.println("Длины списков после вставки:");
        System.out.println("list1:" + list1.size());
        System.out.println("list2:" + list2.size());

        System.out.println();
        try {
            System.out.println(list1.get(2));
            System.out.println(list2.get(3));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Содержимое списков:");
        System.out.println("list1:");
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println("list2:");
        System.out.println(Arrays.toString(list2.toArray()));

        try {
            list1.remove(1);
            list1.remove(2);
            list2.remove("bbb");
            list2.remove("ddd");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Содержимое списков после удаления:");
        System.out.println("list1:");
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println("list2:");
        System.out.println(Arrays.toString(list2.toArray()));*/

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
        System.out.println("Отсортированный список intList2:");
        intList2.selectionSort();
        System.out.println(Arrays.toString(intList2.toArray()));
    }
}