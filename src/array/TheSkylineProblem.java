package array;

import java.util.*;

/**
 * problems-218 https://leetcode-cn.com/problems/the-skyline-problem/
 */
public class TheSkylineProblem {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int buildingNum = buildings.length;
        //扫面线停止的采样点：潜在天际线关键节点横坐标
        List<Integer> samplingPoints = new ArrayList<>(buildingNum);
        for (int[] buiding : buildings) {
            samplingPoints.add(buiding[0]);
            samplingPoints.add(buiding[1]);
        }
        Collections.sort(samplingPoints);

        //扫描线截面的所有房子，高度倒排
        PriorityQueue<int[]> validBuilds = new PriorityQueue<>(buildingNum, (o1, o2) -> o2[2] - o1[2]);

        List<List<Integer>> result = new ArrayList<>(buildingNum);
        int buildingIndex = 0;
        for (int sample : samplingPoints) {
            //记录被扫面线扫到的房子：所有左端点<=采样点的房子入堆
            while (buildingIndex < buildingNum && buildings[buildingIndex][0] <= sample) {
                validBuilds.add(buildings[buildingIndex++]);
            }
            //保留采样点截面覆盖的房子：右端点<=采样点的房子出堆
            while (!validBuilds.isEmpty() && validBuilds.peek()[1] <= sample) {
                validBuilds.poll();
            }
            //扫面线截面高度变化，采样点为天际线关键点横坐标
            int sampleHeight = validBuilds.isEmpty() ? 0 : validBuilds.peek()[2];
            if (result.isEmpty() || result.get(result.size() - 1).get(1) != sampleHeight) {
                result.add(Arrays.asList(sample, sampleHeight));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TheSkylineProblem().getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}));
    }
}
