class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        var dict = new HashSet<String>();
        for(String word: wordDict)
            dict.add(word);
        var cache = new HashMap<Integer, Boolean>();
        cache.put(s.length(), true);
        return helper(0, s, dict, cache); 
    }

    boolean helper(int idx, String s, Set<String> dict, Map<Integer, Boolean> cache) {
        if(cache.containsKey(idx)) return cache.get(idx);
        
        for(int i=idx; i<s.length(); i++) {
            if(dict.contains(s.substring(idx, i+1)) && (helper(i+1, s, dict, cache)))
                return true;
        }
        cache.put(idx, false);
        return false;   
    }
}
