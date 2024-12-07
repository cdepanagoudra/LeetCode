
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] lastSeenS = new int[256];
        int[] lastSeenT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check if the last seen positions differr
            if (lastSeenS[charS] != lastSeenT[charT]) {
                return false;
            }

            // Update the last seen positions
            lastSeenS[charS] = i + 1;
            lastSeenT[charT] = i + 1;
        }

        return true;
    }
}

