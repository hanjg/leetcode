package bitManipulation;

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int count=0;//该段编码之后还应该存在的以0b10开头的字节的字节数
        for(int i=0;i<data.length;i++){
        	if (count==0) {
				if (data[i]>>7==0b0) continue;
				else if(data[i]>>5==0b110) count=1;
				else if(data[i]>>4==0b1110) count=2;
				else if(data[i]>>3==0b11110) count=3;
				else return false;
			}
        	else {
				if(data[i]>>6==0b10) count--;
				else return false;
			}
        }
        return count==0;
    }

}
