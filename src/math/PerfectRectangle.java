package math;
import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
       //刚好围成一个矩形需要满足两个条件：1、最左上，左下，右上，右下的顶点只出现过一次，因为其他顶点出现2次或者4次
    	//2、上面四个点围成的面积等于所有矩形的面积和
    	int minX=Integer.MAX_VALUE,minY=Integer.MAX_VALUE;
    	int maxX=Integer.MIN_VALUE,maxY=Integer.MIN_VALUE;
    	int sumArea=0;
    	Set<String> set=new HashSet<>();//存储当前出现奇数次的顶点
    	for(int i=0;i<rectangles.length;i++){
    		if(rectangles[i][0]<minX) minX=rectangles[i][0];
    		if(rectangles[i][1]<minY) minY=rectangles[i][1];
    		if(rectangles[i][2]>maxX) maxX=rectangles[i][2];
    		if(rectangles[i][3]>maxY) maxY=rectangles[i][3];
    		String s1=rectangles[i][0]+" "+rectangles[i][1];
    		String s2=rectangles[i][2]+" "+rectangles[i][1];
    		String s3=rectangles[i][2]+" "+rectangles[i][3];
    		String s4=rectangles[i][0]+" "+rectangles[i][3];
    		if (set.contains(s1)) {
				set.remove(s1);
			}
    		else {
				set.add(s1);
			}
    		if (set.contains(s2)) {
				set.remove(s2);
			}
    		else {
				set.add(s2);
			}
    		if (set.contains(s3)) {
				set.remove(s3);
			}
    		else {
				set.add(s3);
			}
    		if (set.contains(s4)) {
				set.remove(s4);
			}
    		else {
				set.add(s4);
			}
    		sumArea+=(rectangles[i][2]-rectangles[i][0])*(rectangles[i][3]-rectangles[i][1]);
    		
    	}
    	if (set.size()!=4) {
			return false;
		}
    	if (!set.contains(maxX+" "+maxY)||!set.contains(maxX+" "+minY)|| 
			!set.contains(minX+" "+maxY)||!set.contains(minX+" "+minY)){
    		return false;
		}
    	if (sumArea!=(maxX-minX)*(maxY-minY)) {
			return false;
		}
    	return true;
    }
    public static void main(String[] args){
    	int[][] ar={{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
    	System.out.println(new PerfectRectangle().isRectangleCover(ar));
    }
}
