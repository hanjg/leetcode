package bitManipulation;

public class PowerofFour {
    public boolean isPowerOfFour(int num) {
        if(num<=0) return false;
        if(Integer.bitCount(num)!=1) return false;
        return Integer.toBinaryString(num).length()%2==0;
    }
    
    public boolean isPowerOfFour2(int num) {
    	return num>0&&((Math.log(num)/Math.log(4))-(int)(Math.log(num)/Math.log(4)))==0;
	}

	public boolean isPowerOfFour3(int num) {
		return num>0&&(num&(num-1))==0&&((num&0x55555555)==num);
	}

	public boolean isPowerOfFour4(int num) {
		return num>0&&((num&(num-1))==0)&&(num-1)%3==0;
	}

	public static void main(String[] args){
    	for(int i=0;i<20;i++){
    		System.out.println(Integer.toBinaryString((int)Math.pow(2, i)-1));	
    	}
    }
}
