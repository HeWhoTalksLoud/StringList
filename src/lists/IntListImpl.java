package lists;

import java.util.Arrays;

public class IntListImpl implements IntList {

    private Integer[] array;
    private int size;
    private static final int DEFAULT_ARRAY_SIZE = 10;
    private static final float DEFAULT_WIDEN_COEFFICIENT = 1.5f;

    public IntListImpl() {
        size = 0;
        array = new Integer[DEFAULT_ARRAY_SIZE];
    }

    public IntListImpl(int listSize) {
        size = 0;
        array = new Integer[listSize];
    }
    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    @Override
    public Integer add(Integer item) {
        if (size + 1 == array.length) {
            grow();
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
    public Integer add(int index, Integer item) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Недопустимое значение индекса массива: " + index);
        }

        if (size + 1 == array.length) {
            grow();
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
    public Integer set(int index, Integer item) throws Exception {
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
    public Integer remove(Integer item) throws Exception {
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
    public Integer remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Недопустимое значение индекса массива: " + index);
        }

        Integer item = array[index];
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
    public boolean contains(Integer item) {
        //return (indexOf(item) != -1);

        insertionSort();
        Integer[] arr = Arrays.copyOf(array, array.length);
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(arr[mid])) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) return i;
        }

        return -1;
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    @Override
    public int lastIndexOf(Integer item) {
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
    public Integer get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Недопустимое значение индекса массива: " + index);
        }
        return array[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    @Override
    public boolean equals(IntList otherList) throws Exception {
        if (otherList == null) {
            throw new Exception("В качестве параметра для сравнения передан null");
        }

        if (size != otherList.size()) return false;
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(otherList.get(i))) return false;
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
    public Integer[] toArray() {
        Integer[] newArray;
        newArray = Arrays.copyOf(array, array.length);
        return newArray;
    }

    // Увеличение длины массива в DEFAULT_WIDEN_COEFFICIENT раз.
    private void grow() {
        Integer[] newArray = new Integer[(int) (array.length * DEFAULT_WIDEN_COEFFICIENT)];

        newArray = Arrays.copyOf(array, newArray.length);
        array = newArray;
    }

    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapElements(array, j, j + 1);
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(array, i, minElementIndex);
        }
    }

    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public void quickSort() {
        quickSort(array, 0, size - 1);
    }

    private void quickSort(Integer[] arr, int left, int right) {
        if (left < right) return;

        Integer pivot = arr[right];
        int index = partition(arr, left, right, pivot);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    private int partition(Integer[] arr, int left, int right, Integer pivot) {
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                swapElements(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


}
