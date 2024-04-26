public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void add(int index, T item);
    void set(int index, T item);
    void addFirst(T item);
    void addLast(T item);
    T get(int index);
    T getFirst();
    T getLast();
    T remove(int index); // Change return type to T
    T removeFirst(); // Change return type to T
    T removeLast(); // Change return type to T
    void sort();
    int indexOf(Object object);
    int lastIndexOf(Object object);
    boolean exists(Object object);
    Object[] toArray();
    void clear();
    int size();
}