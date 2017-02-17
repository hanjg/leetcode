package math;

public class AddDigits {
    public int addDigits(int num) {
        while(num>9){
        	int temp=0;
        	while(num>0){
            	temp+=num%10;
            	num/=10;
        	}
        	num=temp;
        }
        return num;
    }

	public int addDigits2(int num) {
		/*if (num==0) {
			return 0;
		}
		return num%9==0?9:num%9;*/
		return 1+(num-1)%9;
	}

}
