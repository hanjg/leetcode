package string;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] num1=version1.split("\\.");
        String[] num2=version2.split("\\.");
        if(num1.length>num2.length)return -1*compareVersion(version2, version1);//num1len小
        int len1=num1.length,len2=num2.length;
        for(int i=0;i<len1;i++){
        	int c1=Integer.valueOf(num1[i]),c2=Integer.valueOf(num2[i]);
        	if(c1>c2)return 1;
        	else if(c1<c2)return -1;
        }
        for(int i=len1;i<len2;i++){
        	if(Integer.valueOf(num2[i])!=0)return -1;
        }
        return 0;
    }
    public static void main(String[] args) {
		System.out.println(new CompareVersionNumbers().compareVersion("1", "0"));
	}
}
