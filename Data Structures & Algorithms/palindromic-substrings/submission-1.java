class Solution {
    public int countSubstrings(String s) {
        var totalPalindromes=0;
        for(int i=0; i<s.length(); i++) {
            var oddCount = palindrome(s, i-1, i+1);
            var evenCount = palindrome(s, i-1, i);
            // Adding 1 count separately to consider char at each index as a palindrome.
            // Another way could be to not add 1 and add length of string seprately along with odd and even
            totalPalindromes = totalPalindromes +  oddCount + evenCount + 1;
        }
        return totalPalindromes;
    }

    private int palindrome(String s, int left, int right) {
        // Returns 0 for a singel char palindrome. 
        // because 1 char palindrome is considered separately in totalPalindrome count.
        int count=0;
        while(left>=0 && right<s.length()) {
            if(s.charAt(left) != s.charAt(right)) 
                break;
            count++;
            left--;
            right++;
        }
        return count;
    }

}
