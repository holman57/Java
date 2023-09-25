public class longest_substring_without_repeating_characters {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0, biggest = 0;
        java.util.HashMap<Character, Integer> m = new java.util.HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (m.containsKey(c) && m.get(c) >= start) start = m.get(c) + 1;
            else biggest = Math.max(biggest, i - start + 1);
            m.put(c, i);
        }
        return biggest;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        int out1 = 3;
        System.out.println((lengthOfLongestSubstring(s1) == out1) ? "Pass" : "Fail");

        String s2 = "bbbbb";
        int out2 = 1;
        System.out.println((lengthOfLongestSubstring(s2) == out2) ? "Pass" : "Fail");

        String s3 = "pwwkew";
        int out3 = 3;
        System.out.println((lengthOfLongestSubstring(s3) == out3) ? "Pass" : "Fail");
    }
}