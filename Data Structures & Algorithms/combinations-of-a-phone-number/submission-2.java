//Revision - Iterative solution
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
        // Important to start with empty string.
        result.add("");
        for(char digit: digits.toCharArray()) {
            // Creating a new list and appending the chars of current digit to existing strings.
            // For every new digit chars, the string created till now is taken and new chars appended to all existing strings.
            var temp = new ArrayList<String>();
            for(String current : result) {
                for(char c : MAPPING.get(digit)) {
                    temp.add(current+c);
                }
            }
            // Set result to strings created till current digit of the input string.
            result = temp;
        }
        return result;
    }
}
