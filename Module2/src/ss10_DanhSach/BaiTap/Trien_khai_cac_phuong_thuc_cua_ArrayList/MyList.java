package ss10_DanhSach.BaiTap.Trien_khai_cac_phuong_thuc_cua_ArrayList;

import java.util.Arrays;

public class MyList<E> implements Cloneable{
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private E elements[];

    MyList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }
    MyList(int capacity) {
        elements = (E[]) new Object[capacity];
    }
    private void ensureCapacity() {
        if(size >= elements.length)
        {
            int newSize = elements.length * 3/2 ;
            elements = Arrays.copyOf(elements, newSize);
        }
    }
    public void add(int index, E element) {
        if(index < 0 || index > size)
            throw new IndexOutOfBoundsException("The " + index + " is out of range");

        ensureCapacity();
        for(int i = size; i > index; i++) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }
    public boolean add(E e) {
        ensureCapacity();
        elements[size++] = e;
        return true;
    }
    public E remove(int index) {
        E temp;
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The " + index + " is out of range");
        }
        else {
            temp = elements[index];
            for(int i = index; i < size - 1; i++) {
                elements[index] = elements[index+1];
            }
        }
        return temp;
    }

    public int size() {
        return size;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public int indexOf(E o) {
        if(o == null) {
            for(int i = 0; i < size; i++)
                if(elements[i] == null) return i;
        }
        else {
            for(int i =0; i < size; i++) {
                if(o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("The " + index + " is out of range");
        }
        else return elements[index];
    }
    public void clear() {
        for(int i=0;i<size;i++)
            elements[i] = null;
        size = 0;
    }
}
