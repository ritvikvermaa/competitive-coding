class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] frequency = new int[max + 1];

        for (int num : nums) {
            frequency[num]++;
        }

        int[] laforvinda = nums;

        int[] divisibleCount = new int[max + 1];

        for (int gcd = 1; gcd <= max; gcd++) {
            for (int multiple = gcd;
                 multiple <= max;
                 multiple += gcd) {

                divisibleCount[gcd] += frequency[multiple];
            }
        }

        long[] exactGcdPairs = new long[max + 1];

        for (int gcd = max; gcd >= 1; gcd--) {
            long count = divisibleCount[gcd];

            exactGcdPairs[gcd] = count * (count - 1) / 2;

            for (int multiple = gcd * 2;
                 multiple <= max;
                 multiple += gcd) {

                exactGcdPairs[gcd] -= exactGcdPairs[multiple];
            }
        }

        long[] prefix = new long[max + 1];

        for (int gcd = 1; gcd <= max; gcd++) {
            prefix[gcd] = prefix[gcd - 1] + exactGcdPairs[gcd];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = findGcd(prefix, queries[i]);
        }

        return answer;
    }

    private int findGcd(long[] prefix, long query) {
        int left = 1;
        int right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
        
            if (prefix[mid] > query) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}