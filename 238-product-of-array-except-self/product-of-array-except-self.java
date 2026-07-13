class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int prev = 1;
        for (int i = 0; i < result.length; i++){
            result[i] = prev;
            prev *= nums[i];
        } 
        int post = 1;
        for (int i = (result.length-1); i >= 0; i--){
            result[i] *= post;
            post *= nums[i];
        }
        return result;
    }
}