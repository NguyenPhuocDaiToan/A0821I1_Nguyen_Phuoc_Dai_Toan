package ss11_Stack_Queue.BaiTap.TrienKhaiQueue_LKVong;

public class Queue implements Solution{
    public Node front;
    public Node rear;
    public Queue() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public void enQueue(int data) {
        Node temp = new Node(data);
        if(front == null) {
            front = rear = temp;
            front.link = rear;
        }
        else {
            rear.link = temp;
            rear = temp;
        }
        rear.link = front;
    }

    @Override
    public Node deQueue() {
        Node temp;
        if(front == null)   return null;
        else {
            if(front == rear) {
                temp = front;
                front = rear = null;
            }
            else {
                temp = front;
                front = front.link;
                rear.link = front;
            }
        }
        return temp;
    }

    @Override
    public void displayQueue() {
        Node k = front;
        do {
            System.out.print(k.data + "\t");
            k = k.link;
        } while(k != front);
    }
}
