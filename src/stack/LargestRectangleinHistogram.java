package stack;
import java.util.Stack;

public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
    	int max=0;
    	Stack<Integer> stack=new Stack<>();//存储波峰图高度递增（或者非递减）的下标
    	for(int i=0;i<=heights.length;i++){
    		int h=i==heights.length?0:heights[i];
    		if (stack.isEmpty()||h>heights[stack.peek()]) {//>||>=
				stack.push(i);
			}
    		else {//计算以当前栈顶点左边和i左边为宽，当前栈顶点对应的高度为长的矩形面积
    			int len=heights[stack.pop()];
    			int width=stack.isEmpty()?i:(i-stack.peek()-1);
    			max=Math.max(max, len*width);
    			i--;
    		}
    	}
    	return max;
    }
	public static void main(String[] args) {
		int[] heights={1};
		System.out.println(heights);
		System.out.println(new LargestRectangleinHistogram().largestRectangleArea(heights));
	}

}
