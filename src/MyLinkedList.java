import java.util.Iterator;
public class MyLinkedList<T> implements MyList<T> {
    private static class MyNode<T>{
        private T element;

        private MyNode<T> next;

        private MyNode<T> prev;

        public MyNode(T element, MyNode<T> next, MyNode<T> prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

    }

    private MyNode<T> head;
    private MyNode<T> tail;

    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public void add(T element) {
        if (size == 0) {
            head = new MyNode<T>(element, null, null);
            tail = head;
        } else {
            MyNode<T> newNode = new MyNode<T>(element, null, tail);
            tail.next = newNode;
            tail = newNode;

        }
        size++;
    }

    @Override
    public void addFirst(T element){
        if (size == 0) {
            head = new MyNode<T>(element, null, null);
            tail = head;
        } else {
            MyNode<T> newNode = new MyNode<T>(element, head, null);
            head.prev = newNode;
            head = newNode;

        }
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == 0) {
            head = new MyNode<T>(item, null, null);
            tail = head;
        } else {
            MyNode<T> newNode = new MyNode<T>(item, null, tail);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T element){

        if(index == 0){
            addFirst(element);
        }else if(index == size){
            add(element);
        }else{
            MyNode<T> current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            MyNode<T> newNode = new MyNode<T>(element, current.next, current);
            current.next.prev = newNode;
            current.next = newNode;
            size++;
        }
    }

    @Override
    public void set(int index, T element){

        if(index == 0){
            head.element = element;
        }else{
            MyNode<T> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            current.element = element;

        }
    }

    @Override
    public T get(int index){
        MyNode<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.element;

    }

    @Override
    public T getFirst(){
        return get(0);
    }

    @Override
    public T getLast(){
        return get(size - 1);
    }

    @Override
    public void remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            head = head.next;
            if(head != null){
                head.prev = null;
            }else{
                tail = null;
            }
        }
        else {
            MyNode<T> current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            current.next = current.next.next;
            if(current.next == null){
                tail = current;
            }else{
                current.next.prev = current;
            }

        }
        size--;

    }

    @Override
    public void removeFirst(){
        remove(0);
    }

    @Override
    public void removeLast(){
        remove(size - 1);
    }

    @Override
    public void sort(){
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (compareTo(get(j), get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            T temp = get(minIndex);
            remove(minIndex);
            add(i, temp);
        }

    }

    @Override
    public int indexOf(Object object){
        MyNode<T> current = head;
        for (int i = 0; i < size; i++){
            if(current.element.equals(object)){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object){
        MyNode<T> current = tail;
        for(int i = size - 1; i >= 0; i--){
            if(current.element.equals(object)){
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object){
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray(){
        Object[] array = new Object[size];
        MyNode<T> current = head;
        for(int i = 0; i < size; i++){
            array[i] = current.element;
            current = current.next;

        }
        return array;

    }

    @Override
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private int compareTo(T a, T b) {
        // Assumes that T implements Comparable
        return ((Comparable<T>) a).compareTo(b);
    }

    private class LinkedListIterator implements Iterator<T> {
        private MyNode<T> current;

        public LinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T element = current.element;
            current = current.next;
            return element;
        }
    }
}
