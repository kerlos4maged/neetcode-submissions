class Solution {

    public String encode(List<String> strs) {
        // first we need to set a modifier or seperator
        // format => NumberOfNextString_word
        // ex: strs=["Hello","World"] => 5_Hello5_World

        // define result string
        String result = "";

        for (String elem : strs) {
            // define element size
            int elementSize = elem.length();
            // wordSize_word
            result = result + String.valueOf(elementSize) + "_" + elem;
        }

        return result;
    }

    public List<String> decode(String str) {
        int length = 0;
        int insideCounter = 0;

        List<String> result = new ArrayList<>();

        for (int idx = 0; idx < str.length(); idx = length + insideCounter + 1) {
            // Counter for search about -> seprator
            insideCounter = idx;
            // loop for search about seprator
            while (str.charAt(insideCounter) != '_') {
                insideCounter = insideCounter + 1;
            }

            // ic => insideCounter
            // 5_ttttt3_jjj
            // first round -> idx=0, ic=0
            // ic loop until get first seprator will be in 1

            // my worng was -> you get start (idx) and end (ic) for wordSize and convert it
            // ex:5_ttttt3_jjj => idx=0, ic= 1, length = 5 you set in method encoding before

            length = Integer.parseInt(str.substring(idx, insideCounter));
            result.add(str.substring(insideCounter + 1, length + 1 + insideCounter));

        }

        return result;

    }
}
