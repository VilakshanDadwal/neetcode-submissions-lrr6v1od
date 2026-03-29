// Revision wit comments
class Solution {
    public List<List<String>> partition(String s) {
        var result = new ArrayList<List<String>>();
        var current = new ArrayList<String>();
        backtrack(s, 0, current, result);
        return result;
    }
    private void backtrack(String s, int idx, List<String> current, List<List<String>> result) {
        // Greater than check important because,
        if(idx==s.length()) {
            result.add(new ArrayList<String>(current));
            return;
        }

        for(int i=idx; i<s.length(); i++) {
            // if not palindrome, cannot have valid answer along current path taking idx-> i substring.
            // but there can be a valid path from idx->i+1(next i) substring. thats why need to continue and not return;
            if(!isPalindrome(s, idx, i)) continue;
            current.add(s.substring(idx, i+1));
            backtrack(s, i+1, current, result);
            current.remove(current.size()-1);
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start<end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
