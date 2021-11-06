package ss4_Class_And_Object.BaiTap.StopWatch;

import java.time.LocalTime;

public class Main {
    public static void selectionSort(int [] a){
        int min_index, temp;
        for(int i=0;i<a.length-1;i++){
            min_index = i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[min_index])
                    min_index = j;
            }
            temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;
        }
    }
    public static void main(String [] args){
        int [] a = new int[100000];
        for(int i=0;i<100000;i++){
            a[i] = (int)(Math.random()*10000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.Start();
        selectionSort(a);
        stopWatch.Stop();

        System.out.println("Thời gian thực hiện thuật toán: " + stopWatch.getElapsedTime());
        for(int value:a){
            System.out.print(value + "\t");
        }
    }
}
