class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet <Character> window =  new HashSet<>();
        int left = 0;
        int longest = 0;
        for (int right = 0; right < s.length(); right++){
            while (window.contains(s.charAt(right))){
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            int len = right - left + 1;
            if (len > longest){
                longest = len;
            }
        }
        return longest;
    }
}