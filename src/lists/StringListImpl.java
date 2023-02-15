package lists;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] array;
    private int size;
    private static final int DEFAULT_ARRAY_SIZE = 10;
    private static final float DEFAULT_WIDEN_COEFFICIENT = 1.5f;
    private static final float DEFAULT_SHORTEN_COEFFICIENT = 0.66f;

    public StringListImpl() {
        size = 0;
        array = new String[DEFAULT_ARRAY_SIZE];
    }

    public StringListImpl(int listSize) {
        size = 0;
        array = new String[listSize];
    }
    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(String item) {
        if (size + 1 == array.length) {
            WidenArray();
        }
        array[size] = item;
        size++;
        return item;
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public String add(int index, String item) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Недопустимое значение индекса массива: " + index);
        }

        if (size + 1 == array.length) {
            WidenArray();
        }

        if (index == size || index == size - 1) {
            array[index] = item;
            size++;
        }
        else {
            for (int i = size; i >= index + 1; i--) {
                array[i] = array[i - 1];
            }
            array[index] = item;
            size++;
        }
        return item;
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Override
    public String set(int index, String item) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Недопустимое значение индекса массива: " + index);
        }
        array[index] = item;
        return item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public String remove(String item) throws Exception {
        int index = indexOf(item);

        if (index == -1) {
            throw new Exception("Элемент '" + item + "' в массиве отсутствует, удаление невозможно");
        }

        return remove(index);
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Override
    public String remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Недопустимое значение индекса массива: " + index);
        }

        String item = array[index];
        if (size < array.length / 2) {
            ShortenArray();
        }
        if (size < 2) {
            clear();
        }
        else {
                for (int i = index; i < size - 1; i++) {
                    array[i] = array[i + 1];
                }
        }
        array[size - 1] = null;
        size--;

        return item;
    }


    // Проверка на существование элемента.
    // Вернуть true/false;
    @Override
    public boolean contains(String item) {
        return (indexOf(item) != -1);
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) return i;
        }

        return -1;
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int lastIndexOf(String item) {
        for (int i = size = 1; i >= 0; i--) {
            if (item.equals(array[i])) return i;
        }
        return -1;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    @Override
    public String get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Недопустимое значение индекса массива: " + index);
        }
        return array[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    @Override
    public boolean equals(StringList otherList) throws Exception {
        if (otherList == null) {
            throw new Exception("В качестве параметра для сравнения передан null");
        }

        if (size != otherList.size()) return false;
        for (int i = 0; i < size; i++) {
            if (get(i) != otherList.get(i)) return false;
        }

        return true;
    }

    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        return size;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    // Удалить все элементы из списка.
    @Override
    public void clear() {
        array[0] = null;
        size = 0;
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    @Override
    public String[] toArray() {
        String[] newArray = new String[size];
        newArray = Arrays.copyOf(array, array.length);
        return newArray;
    }

    // Увеличение длины массива в DEFAULT_WIDEN_COEFFICIENT раз.
    private void WidenArray() {
        String[] newArray = new String[(int) (array.length * DEFAULT_WIDEN_COEFFICIENT)];

        newArray = Arrays.copyOf(array, newArray.length);
        array = newArray;

    }

    // Уменьшение длины массива (умножение длины на DEFAULT_SHORTEN_COEFFICIENT < 1).
    private void ShortenArray() {
        String[] newArray = new String[(int) (array.length * DEFAULT_SHORTEN_COEFFICIENT)];

        newArray = Arrays.copyOf(array, newArray.length);
        array = newArray;

    }
}
