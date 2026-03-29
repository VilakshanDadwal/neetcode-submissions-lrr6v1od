class Solution {
    public int countSubstrings(String s) {
        int count = 1;
        for(int i=1;i<s.length();i++) {
            int countEven = countPalindromes(s, i-1, i);
            int countOdd = countPalindromes(s, i-1, i+1);
            count += 1 + countEven + countOdd;
        }
        return count;
    }

    int countPalindromes(String s, int left, int right) {
        int count=0;
        while(left>=0 && right<s.length()) {
            if(s.charAt(left) != s.charAt(right)) {
                return count;
            }
            count++;
            left--;
            right++;
        }
        return count;
    }
}
