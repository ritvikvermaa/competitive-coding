class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack <Integer> stack = new Stack<>();
        int left[] = new int[n];
        int right[] = new int[n];

        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        for (int i = n-1; i >= 0; i--){
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}