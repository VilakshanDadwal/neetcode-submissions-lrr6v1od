// O(m.n.26) solution
// Done by counting chars and using that as key.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var result = new HashMap<String, List<String>>();
        for(String s: strs) {
            var count = new int[26];
            for(char c: s.toCharArray()) {
                count[c-'a']++;
            }
            var key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }
        return new ArrayList<List<String>>(result.values());
    }
}
