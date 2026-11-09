class Solution {
    public int[] twoSum(int[] nums, int target) {
           var complement = 0;
        var numMap = new Hashtable<Integer, Integer>();

        for (int idx = 0; idx < nums.length; idx++) {
        
            complement = target - nums[idx];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), idx };
            } 
            numMap.put(nums[idx], idx);
        }

        return new int[]{}; 
    }
}
