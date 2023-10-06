import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {
    public static int hourglass(List<List<Integer>> arr, int i, int j) {
        int sum = 0;
        sum += arr.get(i - 1).get(j - 1);
        sum += arr.get(i - 1).get(j);
        sum += arr.get(i - 1).get(j + 1);
        sum += arr.get(i).get(j);
        sum += arr.get(i + 1).get(j - 1);
        sum += arr.get(i + 1).get(j);
        sum += arr.get(i + 1).get(j + 1);
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> arrRowItems = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }
            arr.add(arrRowItems);
        }
        bufferedReader.close();
        int largest_sum = hourglass(arr, 1, 1);
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int sum = hourglass(arr, i, j);
                if (sum > largest_sum) largest_sum = sum;
            }
        }
        System.out.println(largest_sum);
    }
}
