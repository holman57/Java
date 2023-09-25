public class integer_to_roman {
    private static final int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length && num > 0; i++) {
            while (value[i] <= num) {
                num -= value[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int input1 = 3;
        String output1 = "III";
        System.out.println(intToRoman(input1).equals(output1) ? "Pass" : "Fail");

        int input2 = 58;
        String output2 = "LVIII";
        System.out.println(intToRoman(input2).equals(output2) ? "Pass" : "Fail");

        int input3 = 1994;
        String output3 = "MCMXCIV";
        System.out.println(intToRoman(input3).equals(output3) ? "Pass" : "Fail");

    }
}