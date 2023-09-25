import java.util.*;

public class Solution {

    interface PerformOperation {
        boolean operation(int n);
    }

    static PerformOperation isOdd = new PerformOperation() {
        @Override
        public boolean operation(int n) {
            return odd(n);
        }
    };

    private static boolean odd(int n) {
        return n % 2 != 0;
    }

    static PerformOperation isPrime = new PerformOperation() {
        @Override
        public boolean operation(int n) {
            return prime(n);
        }
    };

    private static boolean prime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static PerformOperation isPalindrome = new PerformOperation() {
        @Override
        public boolean operation(int n) {
            return palindrome(n);
        }
    };

    private static boolean palindrome(int n) {
        String numStr = String.valueOf(n);
        int i = 0, j = numStr.length() - 1;
        while (i < j) {
            if (numStr.charAt(i) != numStr.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int opp = scan.nextInt();
            int n = scan.nextInt();
            if (opp == 1) System.out.println(isOdd.operation(n) ? "ODD" : "EVEN");
            if (opp == 2) System.out.println(isPrime.operation(n) ? "PRIME" : "COMPOSITE");
            if (opp == 3) System.out.println(isPalindrome.operation(n) ? "PALINDROME" : "NOT PALINDROME");
        }
        scan.close();
    }
}
