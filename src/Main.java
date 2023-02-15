import lists.StringListImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListImpl list1 = new StringListImpl(5);
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
        System.out.println(Arrays.toString(list2.toArray()));
    }
}