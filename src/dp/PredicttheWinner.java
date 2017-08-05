package dp;

public class PredicttheWinner {
	public boolean PredictTheWinner(int[] nums) {
		int[][] dp = new int[nums.length][nums.length];
		return maxMin(nums, 0, nums.length - 1, dp) >= 0;
	}

	/**
	 * 计算剩余nums[left,right]时，最多可以比对手多的的分数dp[left,right]。<br>
	 * 对手的选择不能掌握，考虑最坏情况。自己的选择可以掌握，选择最好情况。
	 */
	private int maxMin(int[] nums, int left, int right, int[][] dp) {
		System.out.println("cal from "+left+" right"+right);
		if (left == right) {
			dp[left][right] = nums[left];
			System.out.println("dp["
				+ left + "][" + right + "]=" + dp[left][right]);
			return dp[left][right];
		}
		if (dp[left][right] != 0) {
			System.out.println("dp["
					+ left + "][" + right + "]=" + dp[left][right]);
			return dp[left][right];
		}
		// 取左边的值：考虑对手在[left+1，right]之间尽量比自己多得分，即自己最少能的分数
		int getLeft = nums[left] - maxMin(nums, left + 1, right, dp);
		// 取右边的值：考虑对手在[left,right-1]之间尽量比自己多得分，即自己最少能的分数
		int getRight = nums[right] - maxMin(nums, left, right - 1, dp);
		// 取两种情况的最大值
		dp[left][right] = Math.max(getLeft, getRight);
		System.out.println("getLeft=" + getLeft + " getright=" + getRight + "dp["
				+ left + "][" + right + "]=" + dp[left][right]);
		return dp[left][right];
	}

	public static void main(String[] args) {
		new PredicttheWinner().PredictTheWinner(new int[] { 1, 5, 233, 7 });
	}
}
