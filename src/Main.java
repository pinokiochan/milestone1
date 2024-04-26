public class Main {
    public static void main(String[] args) {
        // Test MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("ArrayList size: " + arrayList.size());
        System.out.println("Element at index 1: " + arrayList.get(1));

        // Test MyLinkedList
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add("!");
        System.out.println("LinkedList size: " + linkedList.size());
        System.out.println("First element: " + linkedList.getFirst());

        // Test MyStack
        MyList<Character> characterList = new MyArrayList<>();
        characterList.add('a');
        characterList.add('b');
        MyStack<Character> stack = new MyStack<>(characterList);
        stack.push('c');
        System.out.println("Stack top: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());

        // Test MyQueue
        MyQueue<String> queue = new MyQueue<>(linkedList);
        queue.enqueue("Good");
        queue.enqueue("Morning");
        System.out.println("Queue front: " + queue.peek());
        System.out.println("Queue dequeue: " + queue.dequeue());

        // Test MyMinHeap
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(8);
        System.out.println("MinHeap top: " + minHeap.getMin());
        System.out.println("MinHeap removeMin: " + minHeap.removeMin());
    }
}