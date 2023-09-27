import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

// IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
// Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
// Some valid IP address:
// 000.12.12.034
// 121.234.12.12
// 23.45.12.56
// Some invalid IP address:
// 000.12.234.23.23
// 666.666.23.23
// .213.123.23.32
// 23.45.22.32.
// I.Am.not.an.ip
class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }
}

class MyRegex {

    public String pattern;

    MyRegex() {
        int n = 4;
        StringBuilder sb = new StringBuilder();
        String prefix = "^";
        String range = "(25[0-5]|2[0-4][0-9]|[01]?[0-9]{1,2})";
        String delimiter = "\\.";
        String suffix = "$";

        sb.append(prefix);
        for (int i = 0; i < n; i++) {
            sb.append(range);
            if (i < n - 1) sb.append(delimiter);
            else sb.append(suffix);
        }

        this.pattern = sb.toString();
    }
}