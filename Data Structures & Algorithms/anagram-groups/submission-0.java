class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Object, List<String>> hashtable = new HashMap<Object, List<String>>();

        List<List<String>> result;

        for (int outerValue = 0; outerValue < strs.length; outerValue++) {
            int lenghtForWord = strs[outerValue].length();
            int[] data = new int[26];

            for (int ineerValue = 0; ineerValue < lenghtForWord; ineerValue++) {
                // ["act","pots","tops","cat","stop","hat"]
                // "act" => we here now
                int currentChart = strs[outerValue].charAt(ineerValue);

                // first problem
                currentChart = currentChart - 'a';
                data[currentChart] += 1;
            }
            // second problem
            Object key = Arrays.toString(data);

            // this part we stucked in it

            if (hashtable.containsKey(key)) {
                // key exists: add the word to the existing list
                hashtable.get(key).add(strs[outerValue]);
            } else {
                // first word with this key: create a new list, add the word, store it
                List<String> list = new ArrayList<>();
                list.add(strs[outerValue]);
                hashtable.put(key, list);
            }
        }

        result = new ArrayList<>(hashtable.values());

        return result;
    }

}
