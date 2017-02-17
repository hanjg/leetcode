package dp;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
    	if(s.length()==0)return 0;
        int begin=0,end=-1;//[begin,end]
        int max=0;
        char most='0';
        int[] count=new int[128];
        while(end+1<s.length()){
        	char cur=s.charAt(++end);
        	if(++count[cur]>count[most])most=cur;
        	while(count[most]+k<end-begin+1){
        		char left=s.charAt(begin++);count[left]--;
        		if(left==most){//更新most的状态
        			for(int i=begin;i<=end;i++){
        				if(count[s.charAt(i)]>count[most]){
        					most=s.charAt(i);break;
        				}
        			}
        		}
        	}
        	max=Math.max(max, end-begin+1);
        }
        return max;
    }
    public static void main(String[] args) {
		System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 1));
	}
}
