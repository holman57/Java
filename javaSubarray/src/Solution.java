import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String[] A = scan.nextLine().split(" ");
        int w = n + 1;
        int neg = 0;
        while (w-- > 0) {
            int r = w - 1;
            int l = -1;
            while (r++ < n && l++ < r) {
                int sum = 0;
                for (int i = l; i < r; i++) {
                    sum += Integer.parseInt(A[i]);
                }
                if (sum < 0) neg += 1;
            }
        }
        System.out.println(neg);
    }

}