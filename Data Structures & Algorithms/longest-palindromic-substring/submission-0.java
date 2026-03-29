class Solution {
    public String longestPalindrome(String s) {
        int[] longest = new int[]{0,1};

        for(int i=1; i<s.length(); i++) {
            int[] odd = helper(i-1, i+1, s);
            int[] even = helper(i-1, i, s);
            int[] currentLongest = (odd[1]- odd[0] > even[1] - even[0]) 
                ? odd : even;
            if(currentLongest[1]-currentLongest[0] > longest[1]-longest[0]) {
                longest[0] = currentLongest[0];
                longest[1] = currentLongest[1];
            }
        }
        return s.substring(longest[0], longest[1]);
    }
    int[] helper(int left, int right, String s) {
        while(left>=0 && right < s.length()
         && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
         }
         return new int[]{left+1, right};
    }
}
  