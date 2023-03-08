package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * problems-621 https://leetcode.cn/problems/task-scheduler/
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Task> taskMap = new HashMap<>();
        for (char c : tasks) {
            Task task = taskMap.getOrDefault(c, new Task(c));
            task.leftCount++;
            taskMap.put(c, task);
        }

        int result = 0;
        for (int i = 0; i < tasks.length; i++) {
            Task cur = getTask(taskMap);
            //执行
            int use = cur.coolDown + 1;
            result += use;

            //更新该任务的剩余次数和其他任务的冷却时间
            if (--cur.leftCount == 0) {
                taskMap.remove(cur.name);
            } else {
                cur.coolDown = n;
            }
            for (char c : taskMap.keySet()) {
                if (c == cur.name) {
                    continue;
                }
                Task task = taskMap.get(c);
                task.coolDown = Math.max(0, task.coolDown - use);
            }
        }
        return result;
    }

    private Task getTask(Map<Character, Task> map) {
        Task result = null;
        for (char name : map.keySet()) {
            Task cur = map.get(name);
            if (result == null) {
                result = cur;
            } else {
                if (cur.coolDown < result.coolDown || (cur.coolDown == result.coolDown && cur.leftCount > result.leftCount)) {
                    result = cur;
                }
            }
        }
        return result;
    }


    private class Task {

        private char name;
        private int leftCount;
        private int coolDown;

        private Task(char name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
