package twoPointer;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
    	int minBegin=0,minEnd=0,minWidth=Integer.MAX_VALUE;//最小的窗口
    	//count,need:还需要在s中查找的字符的总数量和各个字符的数量;have:t中是否含有该字符
    	int count=t.length();
    	int[] need=new int[128];
    	boolean[] have=new boolean[128];
    	for(char c:t.toCharArray()){
    		need[c]++;have[c]=true;
    	}
    	int begin=0,end=-1;//s中当前窗口[begin,end]
    	while(end+1<s.length()){
    		while(count>0&&end+1<s.length()){
    			end++;
    			if (have[s.charAt(end)]&&need[s.charAt(end)]-->0) //need[c]<0表示窗口中c超过需要的数量
    				count--;
    		}
    		while(count==0&&begin<=end){
    			if (end-begin+1<minWidth) {
					minBegin=begin;minEnd=end;minWidth=end-begin+1;
				}
    			begin++;
    			if (have[s.charAt(begin-1)]&&++need[s.charAt(begin-1)]>0) 
					count++;
    		}
    	}
    	return minWidth==Integer.MAX_VALUE?"":s.substring(minBegin, minEnd+1);
    }

	public static void main(String[] args){
		MinimumWindowSubstring sol=new MinimumWindowSubstring();
		System.out.println(sol.minWindow("bba", "ab"));
		
	}

}
