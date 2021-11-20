package ss11_Stack_Queue.Optional.ThucHanh.TrienKhaiQueue_Array;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    int head = 0;
    int tail = 0;
    int currentSize = 0;
    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[capacity];
    }
    public boolean isQueueFull() {
        if(currentSize == capacity)
            return true;
        return false;
    }
    public boolean isQueueEmpty() {
        if(currentSize == 0)
            return true;
        return false;
    }
    public void enqueue(int item) {
        if(isQueueFull())
            System.out.println("Overflow! Unable to add element: " + item);
        else {
            if(tail == capacity) {
                tail = 0;
            }
            queueArr[tail] = item;
            tail++;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }
    public void dequeue() {
        if(isQueueEmpty())
            System.out.println("Underflow! Unable remove element from Queue");
        else {
            if(head == capacity) {
                head = 0;
            }
            System.out.println("Pop operation done ! removed: " + queueArr[head]);
            head++;
            currentSize--;
        }
    }
}
