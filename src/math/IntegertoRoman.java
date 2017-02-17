package math;

public class IntegertoRoman {
    public String intToRoman(int num) {
        String[] p4={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] p3={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] p2={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] p1={"","M","MM","MMM"};
        StringBuilder sBuilder=new StringBuilder();
        sBuilder.append(p1[num/1000]);sBuilder.append(p2[num/100%10]);
        sBuilder.append(p3[num/10%10]);sBuilder.append(p4[num%10]);
        return sBuilder.toString();
    }
    
    public static void main(String[]args){
    	System.out.println(new IntegertoRoman().intToRoman(3999));
    }
}
