package stack;

import java.util.Stack;

public class LongestValidParentheses {
   public int longestValidParentheses(String s) {//dp
	   int max=0;
	   int[] dp=new int[s.length()];//从[i,s.length)中的最长匹配括号的长度
	   for(int i=s.length()-2;i>=0;i--){
		   int j=i+1+dp[i+1];//跳过(i+1开始的最长匹配括号)的下标
		   if (s.charAt(i)=='('&&j<s.length()&&s.charAt(j)==')') {//i,j匹配
			   dp[i]=dp[i+1]+2;
			   if(j+1<s.length())dp[i]+=dp[j+1];//[i,j]和[j,s.length)中的最长匹配括号合并
			   max=Math.max(max, dp[i]);
		   }
	   }
	   //for(int i=0;i<dp.length;i++)System.out.print(dp[i]);
	   return max;
   }
   
	public int longestValidParentheses2(String s) {
		Stack<Integer> stack=new Stack<>();//记录未匹配的括号的下标
		stack.push(-1);
		int max=0;
		for(int i=0;i<s.length();i++){
			if (s.charAt(i)==')'&&stack.size()>1&&s.charAt(stack.peek())=='(') {
				//i处的括号可以与栈顶的匹配
				stack.pop();max=Math.max(max, i-stack.peek());
			}
			else {
				stack.push(i);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		LongestValidParentheses bk=new LongestValidParentheses();
		System.out.println(bk.longestValidParentheses("()()"));
	}

}
