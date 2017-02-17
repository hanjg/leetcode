package binarySearch;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)return false;
        int m=matrix.length,n=matrix[0].length;
        int low=0,high=m-1;
        while(low<=high){
        	int mid=(low+high)/2;
        	if(matrix[mid][0]==target)return true;
        	else if (matrix[mid][0]<target){
        		if(target==matrix[mid][n-1])return true;
        		else if(target<matrix[mid][n-1]){
        			low=mid;break;
        		}else {
					low=mid+1;
				}
        	}
        	else high=mid-1;
        }
        int begin=0,end=n-1;
        while(begin<=end){
        	int mid=(begin+end)/2;
        	if(matrix[low][mid]==target)return true;
        	else if(matrix[low][mid]>target)end=mid-1;
        	else begin=mid+1;
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
    	int m=matrix.length;if(m==0)return false;
    	int n=matrix[0].length;if(n==0)return false;
    	int begin=0,end=m*n-1;
    	while(begin<=end){
    		int mid=(begin+end)/2;
    		if(matrix[mid/n][mid%n]==target) return true;
    		else if(target>matrix[mid/n][mid%n]) begin=mid+1;
    		else end=mid-1;
    	}
    	return false;
    }
	public static void main(String[]args){
    	int[][] matrix={{1,1}};
    	System.out.println(new Searcha2DMatrix().searchMatrix2(matrix, 2));
    }
}
