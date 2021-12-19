package weekly;

/**
 * https://leetcode-cn.com/contest/weekly-contest-272/problems/adding-spaces-to-a-string/
 */
public class AddSpaces {

    public String addSpaces(String s, int[] spaces) {
        int cur = 0;
        StringBuilder builder = new StringBuilder();
        for (int index : spaces) {
            while (cur != index) {
                builder.append(s.charAt(cur++));
            }
            builder.append(' ');
        }
        builder.append(s.substring(cur));
        return builder.toString();
    }
}
