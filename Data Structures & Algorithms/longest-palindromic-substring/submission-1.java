class Solution {
    public String longestPalindrome(String s) {
        var longest = new int[2];
        for(int i=0; i<s.length(); i++) {
            // Important to give this index for odd palindrome left and right.
            var odd = palindrome(s, i-1, i+1);
            // Important to give this index for even palindrome left and right.
            var even = palindrome(s, i-1, i);
            var current = odd[1]-odd[0] > even[1]-even[0] ? odd : even;
            longest = current[1]-current[0] > longest[1]-longest[0] ? current : longest;
        }
        return s.substring(longest[0], longest[1]);
    }

    private int[] palindrome(String s, int left, int right) {
        while(left>=0 && right<s.length()) {
            if(s.charAt(left) != s.charAt(right)) 
                break;
            left--;
            right++;
        }
        // This is a key point. Return left+1 so that correct palindrome length is correct.
        // For odd palindrome, the left and right is incremented once after while condition fails.
        // Thats why taking left+1 is important to get start of palindrome. right is exclusive substring method so fine to keep as is.
        return new int[]{left+1, right};
    }
}
