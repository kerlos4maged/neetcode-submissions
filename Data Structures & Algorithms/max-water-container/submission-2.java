class Solution {
    public static int maxArea(int[] heights) {
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int result = 0;

        while (leftPointer < rightPointer) {
            int calc = Math.min(heights[leftPointer], heights[rightPointer]) * (rightPointer - leftPointer);
            if (heights[leftPointer] >= heights[rightPointer]) {
                rightPointer -= 1;
            } else {
                leftPointer += 1;
            }
            result = Math.max(calc, result);
        }
        return result;
    }
}
