// Revision
class Solution {
    public List<List<String>> partition(String s) {
        var result = new ArrayList<List<String>>();
        cut(0, s, new ArrayList<String>(), result);
        return result;
    }

    private void cut(int idx, String s, List<String> current, List<List<String>> result) {
        if(idx == s.length()) {
            result.add(new ArrayList<String>(current));    
            return;
        }

        for(int i=idx; i<s.length(); i++) {
            if(!isPalindrome(idx, i, s)) continue;
            current.add(s.substring(idx, i+1));
            cut(i+1, s, current, result);
            current.remove(current.size()-1);
        }
    }

    private boolean isPalindrome(int left, int right, String s) {
        while(left < right) {
            if(s.charAt(left)!= s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
