// Recursive.
class Solution {
    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 0, 0);
    }

    int minDistance(String s1, String s2, int i, int j) {
        if(i==s1.length() && j==s2.length())
            return 0;
        if(i==s1.length()) return s2.length()-j;
        if(j==s2.length()) return s1.length()-i;

        if(s1.charAt(i) == s2.charAt(j)) 
            return minDistance(s1, s2, i+1, j+1);
        return 1 + Math.min(minDistance(s1, s2, i+1, j),
                            Math.min(
                                    minDistance(s1, s2, i, j+1), 
                                    minDistance(s1, s2, i+1, j+1)));
    }
}
