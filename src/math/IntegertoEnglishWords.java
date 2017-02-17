package math;

public class IntegertoEnglishWords {
	private String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private String[] tens= {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private String[] thousands = {"Billion", "Million","Thousand", "" };
	
    public String numberToWords(int num) {
    	if(num==0)return "zero";
    	int[] group=new int[4];//存放4段数字
    	int i=3;
    	String res="";
    	while(num>0){
    		group[i--]=num%1000;
    		num/=1000;
    	}
    	for(i=0;i<group.length;i++){
    		String word=intToString(group[i]);
    		if(word.length()!=0)res+=word+" "+thousands[i];
    	}
    	return res.trim();
    }
    
    private String intToString(int n){
    	if(n==0)return "";
    	else if(n<20)return " "+less20[n];
    	else if(n<100)return " "+tens[n/10]+intToString(n%10);
    	else return " "+less20[n/100]+" Hundred"+intToString(n%100);
    }
    
    public static void main(String[]args){
    	System.out.println(new IntegertoEnglishWords().numberToWords(12345));
    }

}
