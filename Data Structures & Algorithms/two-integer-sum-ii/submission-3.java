class Solution {
     public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int sumValue = numbers[left] + numbers[right];
            if (sumValue > target) {
                right -= 1;
            } else if (sumValue < target) {
                left += 1;
            } else {
                result[0] = left+1;
                result[1] = right+1;
                break;
            }
        }
        return result;
    }
}
