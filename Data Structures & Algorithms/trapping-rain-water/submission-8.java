class Solution {

 
  public int trap(int[] height) {
        int result = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxLeft = 0;
        int maxRight = height.length - 1;

        while (leftPointer < rightPointer) {
            // first step getting the smallest pointer value
            if (height[leftPointer] <= height[rightPointer]) {
                // height=[0,1,0,2,1,0,1,3,2,1,2,1]
                // tc 7: height=[4,2,3]
                // count 1: check between 0 & height[0] = 0 & 0
                // count 2: check between 0 & height[1] = 0 & 1
                // coutn 3: check between
                if (height[maxLeft] <= height[leftPointer]) {
                    // count 1: maxleft = 0
                    // count 2: maxleft = 1
                    maxLeft = leftPointer;
                }

                // height=[0,1,0,2,1,0,1,3,2,1,2,1]
                // count this pointer to get next value
                // count 1: 0 + 1 = 1
                // count 2: 1 + 1 = 2
                leftPointer = leftPointer + 1;

                // calc value
                // height=[0,1,0,2,1,0,1,3,2,1,2,1]
                // count 1: height[0] - height[1] -> 0 - 1 = -1 skipped
                // count 2: height[1] - height[2] -> 1 - 0 = 1 In
                int value = height[maxLeft] - height[leftPointer];

                if (value >= 0) {
                    // count 2 IN
                    result += value;
                }
            } else {

                if (height[rightPointer] >= height[maxRight]) {

                    maxRight = rightPointer;
                }

                // count this pointer to get next value
                rightPointer = rightPointer - 1;

                // calc value
                int value = height[maxRight] - height[rightPointer];

                if (value >= 0) {
                    result += value;
                }
            }
        }

        return result;
    }

 
 }
