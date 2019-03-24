public class GenericArrayQueue<T> implements QueueInterface<T> 
{
    private T[] data;
    private int front, size, back;

    public final static int DEFAULT_INITIAL_ARRAY_SIZE = 16;
    public static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public GenericArrayQueue() {
        this(DEFAULT_INITIAL_ARRAY_SIZE);
    }

    public GenericArrayQueue(int capacity) throws IllegalArgumentException {
        if (capacity < 1) {
            throw new IllegalArgumentException("Queue capacity must be 1 or greater");
        }

        if (capacity > MAX_ARRAY_SIZE) {
            throw new IllegalArgumentException("Stack capacity is greater then maximum array size");
        }
        T[] tempData = (T[]) new Object[capacity];
        data = tempData;
    }
    public QueueInterface<T> add(T e) throws IllegalArgumentException {
        if (size == data.length) {
            throw new IllegalArgumentException("Ran out of memory to queue");
        }

        data[back] = e;
        back = (back + 1) % data.length;
        size++;
        return this;
    }

      public T element() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Queue does not contain any items.");
        }

        return data[front];
    }

   
    public T remove() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException("Queue does not contain any items.");
        }

        size--;
        T output = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        return output;
    }

      public boolean offer(T e) {
        if (size == data.length) {
            return false;
        }

        size++;
        data[back] = e;
        back = (back + 1) % data.length;
        return true;
    }

      public T peek() {
        return size == 0 ? null : data[front];
    }
    public T poll() {
        if (size == 0) {
            return null;
        }

        T output= data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        return output;
    }
}
interface  QueueInterface<T> 
{
public boolean offer(T e) ;
  public GenericArrayQueue();
     public T peek();
        public T element() ;
            public T remove() ;
                  public boolean offer(T e);
                  }
