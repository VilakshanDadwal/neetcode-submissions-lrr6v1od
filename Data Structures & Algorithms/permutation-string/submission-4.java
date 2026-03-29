// Testing time complexity of my solution
class Solution {
    int matches=0;
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        var freq1 = new int[26];
        var freq2 = new int[26];

        initMatchesAndFreq(s1, s2, freq1, freq2);

        int left = 0;
        for(int right = s1.length(); right < s2.length(); right++) {
            if(matches == 26) return true;
            addCharToWindow(s2, right, freq1, freq2);
            removeCharFromWindow(s2, left, freq1, freq2);
            left++;
        }
        return matches == 26;
    }

    void initMatchesAndFreq(String s1, String s2, int[] freq1, int[] freq2) {
        // Freq of chars till s1 length 
        for(int i=0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        // No of matches to begin with.
        for(int i=0; i<26; i++) {
            if(freq1[i] == freq2[i])
                matches++;
        }
    }
    void addCharToWindow(String s2, int right, int[] freq1, int[] freq2) {
        // Add char to sliding window
        int idx = s2.charAt(right) - 'a';
        freq2[idx]++;
        // When freqCount for s2 is incremented,
        // either it will match the freqCount for s1.
        // OR if it was equal earlier, it will 1 more than s1.
        if(freq1[idx] == freq2[idx]) {
            matches++;
        } else if(freq2[idx] - freq1[idx] == 1){
            matches--;
        }
    }

        void removeCharFromWindow(String s2, int left, int[] freq1, int[] freq2) {
        // Remove char to sliding window
        int idx = s2.charAt(left) - 'a';
        freq2[idx]--;
        // When freqCount for s2 is decremented,
        // either it will match the freqCount for s1.
        // OR if it was equal earlier, it will 1 less than s1.
        if(freq1[idx] == freq2[idx]) {
            matches++;
        } else if(freq1[idx] - freq2[idx] == 1){
            matches--;
        }
    }
}
