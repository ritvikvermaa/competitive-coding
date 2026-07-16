class Solution {
    public long gcdSum(int[] nums) {
      int n = nums.length;
      int maxSoFar = 0;
      int[] prefixGcd = new int[n];
      for (int i = 0; i < n; i++){
        maxSoFar = Math.max(maxSoFar, nums[i]);
        prefixGcd[i] = gcd(nums[i], maxSoFar);
      }
      Arrays.sort(prefixGcd);
      int left = 0;
      int right = n - 1;
      long sum = 0;
      while (left < right){
        sum += gcd(prefixGcd[left], prefixGcd[right]);
        left ++;
        right --;
      }
      return sum;
    }
    private int gcd(int a, int b){
        while (b != 0){
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}