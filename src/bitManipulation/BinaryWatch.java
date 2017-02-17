package bitManipulation;

import java.util.*;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
    	List<String> list=new ArrayList<>();
        for(int i=0;i<12;i++){
        	for(int j=0;j<60;j++){
        		if(Integer.bitCount(i)+Integer.bitCount(j)==num) 
        			list.add(String.format("%d:%02d",i,j));
        	}
        }
        return list;
    }

}
