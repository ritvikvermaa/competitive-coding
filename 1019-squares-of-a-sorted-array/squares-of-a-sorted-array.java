class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] answer = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--){
            if (Math.abs(nums[left]) > Math.abs(nums[right])){
                answer[i] = nums[left] * nums[left];
                left++;
            }
            else{
                answer[i] = nums[right] * nums[right];
                right--;
            }
        }
        return answer;
    }
}