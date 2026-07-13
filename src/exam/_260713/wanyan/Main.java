package exam._260713.wanyan;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * 3 20
     * 5 2 3
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] money = new int[]{5, 2, 3};
//        int target = 20;


        Scanner in = new Scanner(System.in);

        String l1 = in.nextLine();
        String[] l1arr = l1.split(" ");
        int[] money = new int[Integer.parseInt(l1arr[0])];
        int target = Integer.parseInt(l1arr[1]);

        String l2 = in.nextLine();
        String[] l2arr = l2.split(" ");
        for (int i = 0; i < l2arr.length; i++) {
            money[i] = Integer.parseInt(l2arr[i]);
        }

        int[] dp = new int[5001];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int index = 1; index <= target; index++) {
            for (int m : money) {
                if (index >= m) {
                    if (dp[index - m] >= 0) {
                        if (dp[index] == -1) {
                            dp[index] = dp[index - m] + 1;
                        } else {
                            dp[index] = Math.min(dp[index], dp[index - m] + 1);
                        }
                    }
                }
            }
        }
        System.out.println(dp[target]);
    }


}
