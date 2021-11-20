package ss11_Stack_Queue.ThucHanh.TrienKhaiQueue_DSLK;

import ss11_Stack_Queue.BaiTap.TrienKhaiQueue_LKVong.Queue;

public class Test {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        if(queue.deQueue() == null) System.out.println("Danh sách rỗng");
        queue.displayQueue();
    }
}
