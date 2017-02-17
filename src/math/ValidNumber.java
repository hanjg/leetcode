package math;

public class ValidNumber {
    public boolean isNumber(String s) {
    	s=s.trim();
    	boolean beforeE=false,afterE=true,e=false,dot=false;//是否出现e前后的数字、'e'、'.';
    	for(int i=0;i<s.length();i++){
    		char c=s.charAt(i);
    		if (c=='+'||c=='-') {
				if(i!=0&&s.charAt(i-1)!='e')return false;
			}
    		else if (Character.isDigit(c)){
				if(e)afterE=true;
				else beforeE=true;
			}
    		else if (c=='.') {	
				if(dot||e) return false;
				dot=true;
			}
    		else if (c=='e') {
				if(e||!beforeE) return false;
				e=true;afterE=false;
			}
    		else return false;
    	}
    	return beforeE&&afterE;
    }
    public static void main(String[] args) {
		System.out.println(new ValidNumber().isNumber("2e0"));
	}

}
