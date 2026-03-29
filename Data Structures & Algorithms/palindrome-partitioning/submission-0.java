class Solution {
    public List<List<String>> partition(String s) {
        var result = new ArrayList<List<String>>();
        backtrack(s, new ArrayList<String>(), 0, result);
        return result;
    }

    void backtrack(String s, List<String> current, int idx, List<List<String>> result) {
        if(idx == s.length())
            result.add(new ArrayList<String>(current));

        for(int i=idx; i<s.length(); i++) {
            if(isPalindrome(s, idx, i)) {
                String sub = s.substring(idx, i+1);
                current.add(sub);
                backtrack(s, current, i+1, result);
                current.remove(current.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


}
