package binarySearch;

import java.util.TreeSet;

/**
 * problems-855 https://leetcode-cn.com/problems/exam-room/
 */
public class ExamRoom {

    private Integer n;

    /**
     * 已经落座的学生下标，由小到大排序，读写复杂度O(logn)
     */
    private TreeSet<Integer> students;

    public ExamRoom(int N) {
        this.n = N;
        this.students = new TreeSet<>();
    }

    public int seat() {
        int toSeat = 0;
        if (!students.isEmpty()) {
            Integer dist = Integer.MIN_VALUE;
            //判断[0]位置是否合适
            int first = students.first();
            if (first > dist) {
                toSeat = 0;
                dist = first;
            }
            //两两学生之间是否可以插入
            Integer pre = null;
            for (Integer s : students) {
                if (pre != null) {
                    int d = (s - pre) / 2;
                    if (d > dist) {
                        //更新位置和最短距离
                        dist = d;
                        toSeat = pre + d;
                    }
                }
                pre = s;
            }
            //判断[n-1]位置是否合适
            if (n - 1 - students.last() > dist) {
                toSeat = n - 1;
            }
        }
        students.add(toSeat);
        return toSeat;
    }

    public void leave(int p) {
        students.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(10);
        room.seat();
        room.seat();
        room.seat();
        room.seat();
        room.leave(4);
        room.seat();
    }
}
