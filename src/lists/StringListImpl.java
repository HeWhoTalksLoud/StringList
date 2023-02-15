package lists;

public class StringListImpl implements StringList {

    private String[] array;
    private int size;
    private static final int DEFAULT_ARRAY_SIZE = 10;
    private static final float DEFAULT_RESIZE_COEFFICIENT = 1.5f;

    public StringListImpl() {
        size = 0;
        array = new String[DEFAULT_ARRAY_SIZE];
    }

    public StringListImpl(int listSize) {
        size = 0;
        array = new String[DEFAULT_ARRAY_SIZE];
    }
    @Override
    public String add(String item) {
        return null;
    }

    @Override
    public String add(int index, String item) {
        return null;
    }

    @Override
    public String set(int index, String item) {
        return null;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }
}
