import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {
    private MyList<T> list;

    public MyStack(MyList<T> list) {
        this.list = list;
    }

    public void push(T element) {
        list.addLast(element);
    }

    public T pop() { return list.removeLast(); }

    public T peek() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}