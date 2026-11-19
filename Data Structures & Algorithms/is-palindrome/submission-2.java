class Solution {
        public static boolean isPalindrome(String s) {

        s = s.trim().replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int left = 0;

        int right = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left += 1;
            right -= 1;
        }

        return true;
    }
}
