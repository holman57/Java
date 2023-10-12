import java.util.Objects;

public class Solution {
//  Given a string, s, matching the regular expression [A-Za-z !,?._'@]+, split the string into tokens.
//  We define a token to be one or more consecutive English alphabetic letters. Then, print the number of tokens,
//  followed by each token on a new line.
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        String s = scan.nextLine();

        s = s.replaceAll("[^a-zA-Z]+", " ").trim();
        String[] tokens = s.split(" ");
        if (tokens.length < 3) {
            if (java.util.Objects.equals(tokens[0], "")) {
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(tokens.length);
        for (String token : tokens)
            if (!java.util.Objects.equals(token, "")) System.out.println(token);
    }
}

