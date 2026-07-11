class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        var cache = new Boolean[s.length()];
        return wordBreak(0, s, wordDict, cache);
    }

    private Boolean wordBreak(int i, String s, List<String> wordDict, Boolean[] cache) {
        if(i == s.length()) return true;
        if(cache[i] != null) return cache[i];
        cache[i] = false;
        for(String word: wordDict) {
            if(i+word.length() <= s.length()
                && s.substring(i, i + word.length()).equals(word)) {
                    if(wordBreak(i+word.length(), s, wordDict, cache)) {
                        cache[i] = true;
                        break;
                    }
                }
        }
        return cache[i];
    }
}
