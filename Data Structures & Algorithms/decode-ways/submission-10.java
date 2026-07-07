class Solution {
    public int numDecodings(String s) {
        var cache = new int[s.length()];
        Arrays.fill(cache , -1);
        return decodeWays(s, 0, cache);
    }

    int decodeWays(String s, int i, int[] cache) {
        if(i == s.length()) return 1;
        if(cache[i] != -1) return cache[i];

        if(s.charAt(i) == '0') {
            cache[i] = 0;
            return 0;
        }

        cache[i] = decodeWays(s, i+1, cache);

        if(i<s.length()-1 && isValid(s, i)) {
            cache[i] += decodeWays(s, i+2, cache);
        }

        return cache[i];
    }

    boolean isValid(String s, int i) {
        if(s.charAt(i) -'0' > 2 
            || (s.charAt(i) - '0' == 2 && s.charAt(i+1) -'0' > 6))
            return false;
        return true;
    }
}
