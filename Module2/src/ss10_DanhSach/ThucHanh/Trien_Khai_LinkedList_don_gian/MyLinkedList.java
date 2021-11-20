package ss10_DanhSach.ThucHanh.Trien_Khai_LinkedList_don_gian;

import org.w3c.dom.Node;

public class MyLinkedList {
    private Node head;
    private int numNodes;
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return this.data;
        }
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
    }
    public void add(int index, Object data) {
        Node temp = head;
        Node newNode = new Node(data);

        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        numNodes++;
    }
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }
    public Node get(int index){
        Node temp = head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
