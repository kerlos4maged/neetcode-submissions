class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // will create hashmap to count frequancy
        HashMap<Integer, Integer> hashMapData = new HashMap<>();
        // Frequence array => this size will be size for the nums
        // -- ex: [1,2,2,3,3,3] -> if those 6 items have the same value thats mean will
        // be counted 6 times
        // [1,1,1,1] -> count for 1 will be 4 so the size for new array will be (4 + 1)
        List<List<Integer>> frequancy = new ArrayList<>();

        int[] result = new int[k];

        // here we will count each item and set in map
        for (int index = 0; index < nums.length; index++) {
            int key = nums[index];

            if (hashMapData.containsKey(key)) {
                hashMapData.put(key, hashMapData.get(key) + 1);
            } else {
                hashMapData.put(key, 1);
            }
        }

        // specific part for java only you need to fill the list with data before bucket
        // sort

        for (int fillData = 0; fillData < nums.length + 1; fillData++) {
            frequancy.add(new ArrayList<>());
        }

        // here we will move every item counted from hashmap into Bucket Sort
        // we work on hashmap -> so if it has { 3 key : repeated 15 times }
        for (Map.Entry<Integer, Integer> data : hashMapData.entrySet()) {
            // key will be the num & value will be the count
            // index = 4 && repeat = value 19 ex: value = 100, repeated = 4
            // hashtable || value = repeated numbers[4] & key = valueFromNums [100]
            // frequancy[4] = 100
            int key = data.getValue();

            // check if the number of repeated value equal or there's any number else repeat
            // same size
            // ex: value 3 = repated 6
            // ex: value 5 = repated 6

            frequancy.get(key).add(data.getKey());
        }

        // this couter for checking if the result array size == k
        int counter = 0;

        // here we will loop from the end because should if the highest value to be in
        // last value

        for (int i = frequancy.size() - 1; i >= 1; i--) {
            // nested for because maybe in frequancy array inside number of repeated have
            // multi values
            int currentItem = frequancy.get(i).size();

            for (int j = 0; j < currentItem; j++) {
                // result[0] = frequancy[lastitem][0]
                // result[1] = frequancy[lastitem][1]
                // ... etc
                // [1,2,3],k=3 => counter = 0 n, counter =1 n, counter = 2 n, counter = 3y return   
                if (k == counter) {
                    return result;
                }
                result[counter] = frequancy.get(i).get(j);
                counter += 1;
            }
        }

        return result;
    }

}
