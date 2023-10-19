import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input;
            inputLoop: while ((input = in.readLine()) != null) {
                Stack<Character> stack = new Stack<>();
                for (Character c : input.toCharArray()) {
                    switch (c) {
                        case ')': case ']': case '}':
                            if (stack.isEmpty()) {
                                System.out.println("false");
                                continue inputLoop;
                            }
                            if ((stack.peek() == '(' && c == ')') ||
                                    (stack.peek() == '[' && c == ']') ||
                                    (stack.peek() == '{' && c == '}')) {
                                stack.pop();
                                break;
                            } else {
                                System.out.println("false");
                                continue inputLoop;
                            }
                        case '(': case '{': case '[': stack.push(c);
                    }
                }
                if (stack.isEmpty()) System.out.println("true");
                else System.out.println("false");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/*


}}}}
))))
{{{
(((
[]{}(){()}((())){{{}}}{()()}{{}{}}
[[]][][]
}{


false
false
false
false
true
true
false

*/


