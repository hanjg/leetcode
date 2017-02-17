package hashTable;

import java.util.HashMap;

class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }
 
public class MaxPointsonaLine {
    public int maxPoints(Point[] points) {
        int n=points.length,max=0;
        for(int i=0;i<n;i++){
        	int vertical=0,same=0;//与i相同、垂直的点
        	HashMap<Double, Integer>map=new HashMap<>();//与i斜率为K的点的数量
        	for(int j=i+1;j<n;j++){
        		if (points[i].x==points[j].x) {
					if(points[i].y==points[j].y)same++;
					else vertical++;
				}else {
					double k=(double)(points[j].y-points[i].y)/(points[j].x-points[i].x);
					if(k*k==0)k=0;
					map.put(k, map.containsKey(k)?map.get(k)+1:1);
				}
        	}
        	int kMax=0;
        	for(Integer v:map.values())kMax=Math.max(kMax, v);
        	max=Math.max(max, 1+same+Math.max(vertical,kMax	));
        }
        return max;
    }
    public static void main(String[] args) {
		int[][] t={{84,250},{0,0},{1,0},{0,-70},{0,-70},{1,-1},{21,10},{42,90},{-42,-230}};
		Point[] points=new Point[t.length];
		for(int i=0;i<t.length;i++){
			points[i]=new Point(t[i][0], t[i][1]);
		}
		System.out.println(new MaxPointsonaLine().maxPoints(points));
	}

}
