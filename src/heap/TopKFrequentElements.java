package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * problems-347 https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        //计数器
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        //最小堆poll频率低的元素，保留TOP K
        PriorityQueue<Integer> heap = new PriorityQueue<>(nums.length, (o1, o2) -> counter.get(o1) - counter.get(o2));
        for (int num : counter.keySet()) {
            heap.add(num);
            //容量k的最大堆
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements test = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(test.topKFrequent(nums, 2));
    }
}
