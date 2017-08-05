package math;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
    	if (num == 1) {
			return false;
		}
    	int end = (int) Math.sqrt(num);
    	int sum = 1;
    	for (int i = 2; i <= end; i++) {
    		if (num % i == 0) {
				sum += i + num / i;
			}
    	}
//    	System.out.println("end=" + end + " sum=" + sum);
    	return sum == num;
    }
}
