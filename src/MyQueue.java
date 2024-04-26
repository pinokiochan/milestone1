import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    private MyList<T> list;

    public MyQueue(MyList<T> list) {
        this.list = list;
    }

    public void enqueue(T element) {
        list.addFirst(element);
    }

    public T dequeue() {
        return list.removeFirst();
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}