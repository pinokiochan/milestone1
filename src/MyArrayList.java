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
        elements[size] = item;
        size++;
    }

    @Override
    public void set(int index, T item){
        elements[index] = item;
    }

    @Override
    public void add(int index, T item){
        for(int i = size - 1; i <= index; i--){
            elements[i + 1] = elements[i];
        }
        elements[index] = item;
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
        for(int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
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
    public void sort(){
        for ( int i = 0; i < size - 1; i++){

            for ( int j = 0; j < size - i - 1; j++){


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
}

