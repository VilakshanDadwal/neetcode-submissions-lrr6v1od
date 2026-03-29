// Revision - Backtracking solution.
class Solution {
    static Map<Character, List<Character>> MAPPING = new HashMap<Character, List<Character>>();
    static {
        MAPPING.put('0', List.of());
        MAPPING.put('1', List.of());
        MAPPING.put('2', List.of('a', 'b', 'c'));
        MAPPING.put('3', List.of('d', 'e', 'f'));
        MAPPING.put('4', List.of('g', 'h', 'i'));    
        MAPPING.put('5', List.of('j', 'k', 'l'));
        MAPPING.put('6', List.of('m', 'n', 'o'));
        MAPPING.put('7', List.of('p', 'q', 'r', 's'));
        MAPPING.put('8', List.of('t', 'u', 'v'));
        MAPPING.put('9', List.of('w', 'x', 'y', 'z'));
    }
    public List<String> letterCombinations(String digits) {
        var result = new ArrayList<String>();
        if(digits.isEmpty()) return result;
        backtrack(0, digits, "", result);
        return result;
    }
    private void backtrack(int idx, String digits, String current, List<String> result) {
        if(idx == digits.length()) {
            result.add(current);
            return;
        }
        for(char c : MAPPING.get(digits.charAt(idx))) {
            backtrack(idx+1, digits, current+c, result);
        }
    }
}
