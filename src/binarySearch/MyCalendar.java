package binarySearch;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * * problems-729 https://leetcode.cn/problems/my-calendar-i
 */
public class MyCalendar {

    private TreeSet<int[]> calendar;

    public MyCalendar() {
        calendar = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    }

    public boolean book(int startTime, int endTime) {
        int[] newEvent = {startTime, endTime};
        int[] floorEvent = calendar.floor(newEvent);
        int[] ceilingEvent = calendar.ceiling(newEvent);

        if ((floorEvent == null || floorEvent[1] <= startTime) && (ceilingEvent == null || ceilingEvent[0] >= endTime)) {
            calendar.add(newEvent);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20)); // returns true
        System.out.println(calendar.book(15, 25)); // returns false, because time 15 is already booked by another event
        System.out.println(calendar.book(20, 30)); // returns true, because the event can be booked as the first event ends at time 20 and the second event starts at time 20.
    }
}
