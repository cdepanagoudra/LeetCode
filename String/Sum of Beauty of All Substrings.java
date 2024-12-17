java
Copy code
class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int beautySum = 0;

        // Iterate through all starting indices
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // Frequency array for 26 lowercase letters

            // Iterate through all ending indices
            for (int j = i; j < n; j++) {
                // Update frequency of the current character
                freq[s.charAt(j) - 'a']++;

                // Calculate max and min frequency
                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;

                for (int f : freq) {
                    if (f > 0) { // Ignore characters with frequency 0
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                // Add beauty of current substring
                beautySum += (maxFreq - minFreq);
            }
        }
        return beautySum;
    }
}

