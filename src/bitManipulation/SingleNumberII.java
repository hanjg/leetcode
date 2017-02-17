package bitManipulation;

public class SingleNumberII {
    public int singleNumber(int[] nums) {//用int【32】数组来储存所有数据中各个二进制位上1出现的次数
        int[] bitNum=new int[32];
        for(int i=0;i<nums.length;i++){
        	for(int j=0;j<32;j++){
        		bitNum[j]+=(nums[i]>>(31-j))&1;//表示nums[i]的32为bit中正数第j+1位的bit出现的次数
        	}
        }
        int result=0;
        for(int i=0;i<bitNum.length;i++){
        	result=result|(bitNum[i]%3)<<(31-i);//%后出现不到3次的数每个bit位出现的次数为bitNum[i]%3
        }
        return result;
    }
    @SuppressWarnings("unused")
	private void print(int ones,int twos,int threes){
    	System.out.println(Integer.toBinaryString(ones)+"\t"+Integer.toBinaryString(twos)+"\t"
    			+Integer.toBinaryString(threes));
    }
	public int singleNumber2(int[] nums) {
		int ones=0,twos=0,threes=0;//第i位只出现1、2、3次的掩码变量，二进制码的第i位为1代表这一位出现1、2、3次
		for(int i=0;i<nums.length;i++){
			//System.out.println("nums["+i+"]="+Integer.toBinaryString(nums[i]));
			twos |= ones & nums[i];//print(ones, twos, threes);
			ones ^= nums[i];//print(ones, twos, threes);
			// 异或3次 和 异或 1次的结果是一样的
			
			//对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
			threes = ones & twos;//print(ones, twos, threes);
			ones &= ~threes;//print(ones, twos, threes);
			twos &= ~threes;//print(ones, twos, threes);
		}
		return ones;
	}

	public static void main(String[] args) {
		SingleNumberII test=new SingleNumberII();
		int [] nums={2,3,4,5,4,5,4,5,3,3};
		System.out.println(test.singleNumber2(nums));
	}

}
