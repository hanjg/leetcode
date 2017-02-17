package math;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
        	res=res*26+s.charAt(i)-(char)('A'-1);
        }
        return res;
    }

}
