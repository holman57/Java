import java.io.*;
import java.util.*;

public class Solution {

//    System.out.println(A.equals(new StringBuffer(A).reverse().toString()) ? "Yes" : "No");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int left = 0, right = A.length() - 1;
        while (left <= right) {
            if (A.charAt(left) != A.charAt(right)) {
                System.out.println("No");
                break;
            }
            left += 1;
            right -= 1;
            if (left >= right) {
                System.out.println("Yes");
                break;
            }
        }
    }
}
