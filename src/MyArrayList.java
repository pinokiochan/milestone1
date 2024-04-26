import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object [] elements;
    private int size;

    public MyArrayList(){
        elements = new Object[10];
        size = 0;
    }

    @Override
    public void add(T item){
        if (size == elements.length) {
            resize(elements.length * 2);
        }
        elements[size] = item;
        size++;
    }

    @Override
    public void set(int index, T item){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = item;

    }

    @Override
    public void add(int index, T element){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(size == elements.length){
            resize(elements.length * 2);
        }
        for(int i = size;  i > 0; i--){
            elements[i + 1] = elements[i];

        }
        elements[index] = element;
        size++;
    }

    @Override
    public void addFirst(T item){
        add(0, item);
    }

    @Override
    public void addLast(T item){
        add( size , item);
    }

    @Override
    public T get(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    @Override
    public T getFirst(){
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        return (T) elements[size];
    }

    @Override
    public void remove(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        for(int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    @Override
    public void removeFirst(){
        remove(0);
    }

    @Override
    public void removeLast(){
        remove(size);
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {

            for (int j = 0; j < size - i - 1; j++) {
                if (compareTo((T) elements[j], (T) elements[j + 1]) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }


            }
        }
    }

    @Override
    public int indexOf(Object object){
        for(int i = 0; i < size; i++){
            if(elements[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object){
        for(int i = size - 1; i >= 0; i--){
            if(elements[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray(){
        Object[] array = new Object[size];
        for(int i = 0; i < size; i++){
            array[i] = elements[i];
        }
        return array;
    }

    @Override
    public  void clear(){
        for(int i = 0; i < size; i++){
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public int size(){ return size;}

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private void resize(int newSize) {
        Object[] newElements = new Object[newSize];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    private int compareTo(T a, T b) {
        // Assumes that T implements Comparable
        return ((Comparable<T>) a).compareTo(b);
    }

    private class ArrayListIterator implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return (T) elements[index++];
        }
    }
}


