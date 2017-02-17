package math;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String reString="";
        while(n>0){
        	char c=(char)((n-1)%26+'A');
        	reString=c+reString;
        	n=(n-1)/26;
        }
        return reString;
    }
    public static void main(String[] args){
    	System.out.println(new ExcelSheetColumnTitle().convertToTitle(85));
    }
}
