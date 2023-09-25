import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        scan.close();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static void readIntString() {
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        scan.close();
        String str = in.replaceAll("[0-9 ]", "");
        int n = Integer.parseInt(in.replaceAll("[a-zA-Z ]", ""));

        System.out.println("myString is: " + str);
        System.out.println("myInt is: " + n);
    }
}