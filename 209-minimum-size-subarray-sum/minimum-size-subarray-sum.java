class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int sum = 0;
        int size = Integer.MAX_VALUE;
        for (int high = 0; high < nums.length; high++){
            sum += nums[high];
            while (sum >= target){
                size = Math.min(size, high - low + 1);
                sum -= nums[low];
                low++;
            }
        }
        if (size == Integer.MAX_VALUE){
            size = 0;
        }
        return size;
    }
}