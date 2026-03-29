class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        var sMap = new HashMap<Character, Integer>();
        var tMap = new HashMap<Character, Integer>();

        for(int i=0; i<s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sMap.equals(tMap);
    }
}
