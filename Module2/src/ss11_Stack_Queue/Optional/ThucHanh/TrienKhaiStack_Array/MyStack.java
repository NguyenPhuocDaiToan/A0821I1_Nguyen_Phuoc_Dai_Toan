package ss11_Stack_Queue.Optional.ThucHanh.TrienKhaiStack_Array;

public class MyStack {
    private int[] arr;
    int size;
    int index;
    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
    }
    public boolean isFull() {
        if(index == size)
            return true;
        return false;
    }
    public boolean isEmpty() {
        if(index == 0)
            return true;
        return false;
    }
    public void push(int element) {
        if(isFull())
            throw new StackOverflowError("Stack is full");
        arr[index++] = element;
    }
    public int pop() throws Exception {
        if(isEmpty())
            throw new Exception("Stack is null");
        return arr[--index];
    }
    public int size() {
        return index;
    }
}
