// Memoized
class Solution {
    public int numDecodings(String s) {
        var nums = new HashSet<String>();
        var cache = new int[s.length()];
        Arrays.fill(cache, -1);
        for(int i=1; i<=26; i++) {
            nums.add(String.valueOf(i));
        }
        return helper(0, s, nums, cache);
    }
    int helper(int i, String s, Set<String> nums, int[] cache) {
        if(i==s.length()) return 1;
        if(i>s.length()) return 0;
        int ways = 0;
        if(s.charAt(i) != '0') {
            ways = helper(i+1, s, nums, cache);
        }
        if(i < s.length()-1 && nums.contains(s.substring(i,i+2))) {
            ways+= helper(i+2,s, nums, cache);
        }
        cache[i] = ways;
        return cache[i];
    }
}
