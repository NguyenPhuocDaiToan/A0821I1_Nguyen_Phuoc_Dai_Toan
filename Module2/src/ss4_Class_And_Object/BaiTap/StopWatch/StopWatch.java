package ss4_Class_And_Object.BaiTap.StopWatch;

import java.time.LocalTime;

public class StopWatch {
    LocalTime startTime, endTime;
    public StopWatch(){
        this.startTime = LocalTime.now();
    }
    public void Start() {
        this.startTime = LocalTime.now();
    }
    public void Stop() {
        this.endTime = LocalTime.now();
    }
    public int getElapsedTime(){
        int hour = endTime.getHour() - startTime.getHour();
        int minute = endTime.getMinute() - startTime.getMinute();
        int second = endTime.getSecond() - startTime.getSecond();
        return (hour*3600 + minute*60 + second)*1000;
    }
}
