package array;
import java.util.*;
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<>();
        if (nums.length==0) {
			return result;
		}
        for(int i=0;i<nums.length;i++){
        	int start=nums[i];
        	while(i+1<nums.length&&nums[i+1]==nums[i]+1) i++;//将i指向连续数据的最后一项
        	if (nums[i]==start) {//这一段数据只有一项
				result.add(new String(start+""));
			}
        	else {
				result.add(new String(start+"->"+nums[i]));
			}
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
