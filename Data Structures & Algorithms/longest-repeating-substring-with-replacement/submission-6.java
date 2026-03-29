// Sliding Window solution that finds maxFreq char each time.
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            freq[s.charAt(r) - 'A']++;
            while ((r - l + 1) - getMaxFreq(freq) > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    private int getMaxFreq(int[] freq) {
        int max = 0;
        for (int f : freq) {
            max = Math.max(max, f);
        }
        return max;
    }
}
