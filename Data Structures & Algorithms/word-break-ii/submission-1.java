class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        var words = new HashSet<String>();
        for(var word: wordDict) {
            words.add(word);
        }

        var result = new ArrayList<String>();
        wordBreak(0, s, words, new ArrayList<String>(), result);
        return result;
    }

    void wordBreak(int idx, String s, Set<String> words, List<String> current, List<String> result) {
        if(idx == s.length()) {
            result.add(String.join(" ", current));
            return;
        }

        for(int i=idx; i<s.length(); i++) {
            
            if(!words.contains(s.substring(idx, i+1))) continue;

            current.add(s.substring(idx, i+1));
            wordBreak(i+1, s, words, current, result);
            current.remove(current.size()-1);
        }
    }
}