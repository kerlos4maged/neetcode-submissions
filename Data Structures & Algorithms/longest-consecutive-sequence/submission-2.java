class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> setOfValues = new HashSet<>();
        int result = 0;
        // Steps
        // 1- add nums into set

        for (Integer elem : nums) {
            setOfValues.add(elem);
        }

        for (Integer itemObject : setOfValues) {
            // 2- we will get previous number
            int previousItem = itemObject - 1;
            // 3- if previous number exist
            if (!setOfValues.contains(previousItem)) {
                // 4- we found previous item so now we will count the length
                int length = 0;

                // 5- while if next item exist continue
                while (setOfValues.contains(itemObject + length)) {
                    length = length + 1;
                }

                // 6- if not exist means this chain broken so check the previous result and the
                // current

                result = Math.max(result, length);
            }

        }

        return result;
    }

}
