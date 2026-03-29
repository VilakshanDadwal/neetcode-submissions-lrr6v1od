class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        var cache = new HashMap<Integer, Boolean>();
        cache.put(s.length(), true);
        return helper(0, s, wordDict, cache); 
    }

    boolean helper(int idx, String s, List<String> dict, Map<Integer, Boolean> cache) {
        if(cache.containsKey(idx)) return cache.get(idx);
        for(String dictWord: dict) {
            if(idx+dictWord.length() <= s.length() 
            && s.substring(idx, idx + dictWord.length()).equals(dictWord) 
            && helper(idx+dictWord.length(), s, dict, cache)){
                cache.put(idx, true);
                return true;
            }
        }
        cache.put(idx, false);
        return false;   
    }
}
