class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            var sortedString = new String(chars);
            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
