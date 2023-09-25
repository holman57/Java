public class three_sum_closest {

    public static int threeSumClosest(int[] nums, int target) {
        int d = Integer.MAX_VALUE;
        int s_length = nums.length;
        java.util.Arrays.sort(nums);
        for (int i = 0; i < s_length && d != 0; ++i) {
            int a = i + 1;
            int z = s_length - 1;
            while (a < z) {
                int sum = nums[i] + nums[a] + nums[z];
                if (Math.abs(target - sum) < Math.abs(d)) d = target - sum;
                if (sum < target) ++a;
                else --z;
            }
        }
        return target - d;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        int output1 = 2;
        System.out.println(threeSumClosest(nums1, target1) == output1 ? "Pass" : "Fail");

        int[] nums2 = {0, 0, 0};
        int target2 = 0;
        int output2 = 0;
        System.out.println(threeSumClosest(nums2, target2) == output2 ? "Pass" : "Fail");
    }
}
