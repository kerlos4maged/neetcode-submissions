class Solution {
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> answer = new ArrayList<>();
    Arrays.sort(nums);

    for (int index = 0; index < nums.length - 2; index++) {
        // تخطي index المتكرر
        if (index > 0 && nums[index] == nums[index - 1]) continue;

        int fPointer = index + 1;
        int sPointer = nums.length - 1;

        while (fPointer < sPointer) {
            int sumValue = nums[index] + nums[fPointer] + nums[sPointer];

            if (sumValue > 0) {
                sPointer--;
            } else if (sumValue < 0) {
                fPointer++;
            } else {
                answer.add(List.of(nums[index], nums[fPointer], nums[sPointer]));
                fPointer++;
                sPointer--;
                // تخطي fPointer المتكرر
                while (fPointer < sPointer && nums[fPointer] == nums[fPointer - 1]) {
                    fPointer++;
                }
            }
        }
    }
    return answer;
}
}
