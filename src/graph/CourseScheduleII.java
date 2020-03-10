package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * problems-210 https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //课程学习路径
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        //课程入度
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        //入度为0代表可以学习
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] path = new int[numCourses];
        int pathIndex = 0;
        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            //学习course
            path[pathIndex++] = course;
            for (int to : graph.get(course)) {
                if (--indegree[to] == 0) {
                    queue.add(to);
                }
            }
        }
        return pathIndex == numCourses ? path : new int[0];
    }
}
