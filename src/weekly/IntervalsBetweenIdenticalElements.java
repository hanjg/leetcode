package weekly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/intervals-between-identical-elements/
 */
public class IntervalsBetweenIdenticalElements {

    public long[] getDistances(int[] arr) {
        int n = arr.length;
        //数字：所有的下标
        Map<Integer, List<Integer>> positionMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = positionMap.computeIfAbsent(arr[i], k -> new ArrayList<>());
            list.add(i);
        }

        long[] result = new long[arr.length];
        for (int num : positionMap.keySet()) {
            List<Integer> positionList = positionMap.get(num);
            //小于i的位置和i的所有距离和
            long[] preSum = new long[positionList.size()];
            //大于i的位置所有距离和
            long[] postSum = new long[positionList.size()];
            for (int i = 1; i < positionList.size(); i++) {
                preSum[i] = preSum[i - 1] + i * (positionList.get(i) - positionList.get(i - 1));
            }
            for (int i = positionList.size() - 2; i >= 0; i--) {
                postSum[i] = postSum[i + 1] + (positionList.size() - i - 1) * (positionList.get(i + 1) - positionList.get(i));
            }
            for (int i = 0; i < positionList.size(); i++) {
                result[positionList.get(i)] = preSum[i] + postSum[i];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        long[] r = new IntervalsBetweenIdenticalElements().getDistances(new int[]{2, 1, 3, 1, 2, 3, 3});
        for (long i : r) {
            System.out.print(i + ", ");
        }
    }
}
