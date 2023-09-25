import java.util.stream.IntStream;

public class SubSequence {
    public static boolean isSubsequenceIterate(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        int[] u = IntStream.generate(()->0).limit(s.length()).toArray();
        int i = 0, j = 0;
        while (i < t.length() && j < s.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                u[j] = 1;
                j++;
            }
            i++;
        }
        int sum = IntStream.of(u).reduce(0, Integer::sum);
        return sum == s.length();
    }

    public static boolean isSubsequence(String s, String t) {
        int leftBound = s.length(), rightBound = t.length();
        int pLeft = 0, pRight = 0;
        while (pLeft < leftBound && pRight < rightBound) {
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }

    public static void main(String[] args) {
        String seq1 = "abc";
        String string1 = "ahbgdc";
        System.out.println(isSubsequence(seq1, string1));

        String seq2 = "axc";
        String string2 = "ahbgdc";
        System.out.println(isSubsequence(seq2, string2));
    }
}