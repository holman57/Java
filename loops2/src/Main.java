import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            List<Integer> intList = new ArrayList<>();
            int value = a;
            for (int j = 0; j < n; j++) {
                value += (int) Math.pow(2, j) * b;
                intList.add(value);
            }
            System.out.println(Arrays.toString(intList.toArray()).replaceAll("[\\[\\],]", ""));
        }
        in.close();
    }
}