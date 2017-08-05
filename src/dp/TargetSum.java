package dp;

public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return (sum < S || (sum + S) % 2 != 0) ? 0 : getPositive(nums, (sum + S) / 2);
	}

	/**
	 * 在nums中和为target的组合的个数
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
//	private int getPositive(int[] nums, int target) {
//		// 和为i的组合数为dp[i]
//		int[] dp = new int[target + 1];
//		dp[0] = 1;
//		for (int num : nums) {
//			for (int i = target; i >= num; i--) {
//				dp[i] += dp[i - num];
//			}
//		}
//		return dp[target];
//	}
	
	private int getPositive(int[] nums, int target) {
		// 和为i的组合数为dp[i]
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int i = num; i <= target;i++) {
				dp[i] += dp[i - num];
			}
		}
		return dp[target];
	}
	private void getDP(int[] nums, int index) {
		
	}
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int S = 3;
		System.out.println(new TargetSum().findTargetSumWays(nums, S));
		;
	}

}

