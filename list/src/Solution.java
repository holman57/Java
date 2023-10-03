
public class Solution {

    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int n = scan.nextInt();
        String input = scan.nextLine();
        java.util.List<String> l = new java.util.ArrayList<>(java.util.List.of(input.split(" ")));
        int q = scan.nextInt();
        while (q-- > 0) {
            String query = scan.nextLine();
            String[] inputs = query.split(" ");
            switch (inputs[0]) {
                case "Insert": l.add(Integer.parseInt(inputs[1]), inputs[2]);
                case "Delete": l.remove(inputs[1]);
            }
        }
        System.out.println(l);
    }
}
