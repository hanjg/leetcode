package twoPointer;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] res=new int[2];
		if(nums.length<2)return res;
		HashMap<Integer, Integer> map=new HashMap<>();//K=数值，V=下标，存放已经访问过的数
		for(int i=0;i<nums.length;i++){
			int att=target-nums[i];
			if(map.containsKey(att)){//map中是否存在与nums[i]和为target的数
				res[0]=i;res[1]=map.get(att);
				break;
			}
			map.put(nums[i], i);
		}
		return res;
	}
	public static void main(String[] args) {
		TwoSum solution=new TwoSum();
		int[] nums={0,4,3,0};
		int[] result=solution.twoSum(nums, 0);
		System.out.println(result[0]+" "+result[1]);
	}

}
