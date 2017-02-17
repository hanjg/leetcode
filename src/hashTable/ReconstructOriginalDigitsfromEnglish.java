package hashTable;
// z 0
// e 0 1 3 3 5 7 7 8 9
// r 0 3 4
// o 0 1 2 4
// n 1 7 9 9
// t 2 3 8
// w 2
// h 3 8
// f 4 5
// u 4
// i 5 6 8 9
// v 5 7
// s 6 7
// x 6
// g 8

public class ReconstructOriginalDigitsfromEnglish {
    public String originalDigits(String s) {
        int[] count=new int[10];//记录[0,9]在s中出现的次数
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);
        	if(c=='z')count[0]++;//0
        	else if(c=='w')count[2]++;//2
        	else if(c=='u')count[4]++;//4
        	else if(c=='x')count[6]++;//6
        	else if(c=='g')count[8]++;//8
        	else if(c=='h')count[3]++;//3,8
        	else if(c=='f')count[5]++;//4,5
        	else if(c=='s')count[7]++;//6,7
        	else if(c=='o')count[1]++;//0,1,2,4
        	else if(c=='i')count[9]++;//5,6,8,9
        }
        count[3]-=count[8];
        count[5]-=count[4];
        count[7]-=count[6];
        count[1]-=count[0]+count[2]+count[4];
        count[9]-=count[5]+count[6]+count[8];
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<10;i++){
        	for(int j=0;j<count[i];j++)builder.append(i);
        }
        return builder.toString();
    }
}
