import java.io.*;
import java.util.*;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        List<String> subStringList = new ArrayList<String>();
        int index = 0;
        int stringSize = s.length();
        while (index <= stringSize - k) {
            String subString = s.substring(index, index + k);
            int priority = 0;
            while (priority <= subStringList.size() - 1 &&
                    subString.compareTo(subStringList.get(priority)) > 0) {
                priority += 1;
            }
            subStringList.add(priority, subString);
            index += 1;
        }
        String smallest = subStringList.get(0);
        String largest = subStringList.get(subStringList.size() - 1);
        return smallest + "\n" + largest;
    }

    public static String getSmallestAndLargestTree(String s, int k) {
        java.util.Set<String> set = new java.util.TreeSet<>();
        for(int i = 0; i <= (s.length() - k); i++)
            set.add(s.substring(i, (i + k)));
        Object[] sa = set.toArray();
        return sa[0] + "\n" + sa[sa.length - 1];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargest(s, k));
    }
}