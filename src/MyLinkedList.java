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

    }






}
