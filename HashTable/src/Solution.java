import java.util.HashMap;
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> table = new HashMap<>();
        int i = 0;
        while (i < nums.length) {
            int x = target - nums[i];
            if (table.containsKey(x)) {
                return new int[] {table.get(x), i};
            }
            table.put(nums[i], i);
            i++;
        }
        return null;
    }
}