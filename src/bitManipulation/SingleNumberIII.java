package bitManipulation;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor=0;//两个只出现一次的数的异或值
        for(int i=0;i<nums.length;i++){
        	xor^=nums[i];
        }
        int dif=xor&(-xor);
        //dif为xor中取最右端的1代表的数，表示这两个数在这一位上分别为1和0，可以此将原数组分为两组,使得这两个数在不同的组
        //如xor=01110 -xor(按位取反后+1)=10010 则dif=00010
        int nums1=0,nums2=0;
        for(int i=0;i<nums.length;i++){
        	if ((nums[i]&dif)>0) {
				nums1^=nums[i];
			}
        	else {
				nums2^=nums[i];
			}
        }
        int [] result={nums1,nums2};
        return result;
    }
}
