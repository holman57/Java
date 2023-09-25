import java.util.Arrays;

public class two_sum {
    public static int[] twosum(int[] nums, int target) {
        java.util.HashMap<Integer, Integer> m = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (m.containsKey(x)) return new int[] {m.get(x), i};
            m.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a1 = {2, 7, 11, 15};
        int t1 = 9;
        System.out.println(Arrays.toString(twosum(a1, t1)) + " [0, 1]");

        int[] a2 = {3, 2, 4};
        int t2 = 6;
        System.out.println(Arrays.toString(twosum(a2, t2)) + " [1, 2]");

        int[] a3 = {3, 3};
        int t3 = 6;
        System.out.println(Arrays.toString(twosum(a3, t3)) + " [0, 1]");
    }
}