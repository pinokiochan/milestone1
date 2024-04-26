import java.util.Iterator;

public class MyMinHeap<T extends Comparable<T>> implements Iterable<T> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<T>();
    }

    public void add(T item) {
        heap.add(item);
        int index = heap.size() - 1;
        while (index > 0 && heap.get(parent(index)).compareTo(heap.get(index)) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public T removeMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        int index = 0;
        while (true) {
            int leftChildIndex = leftChild(index);
            int rightChildIndex = rightChild(index);
            int minIndex = index;
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(minIndex)) < 0) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(minIndex)) < 0) {
                minIndex = rightChildIndex;
            }
            if (minIndex == index) {
                break;
            }
            swap(index, minIndex);
            index = minIndex;
        }
        return min;
    }

    public T getMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return heap.iterator();
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}