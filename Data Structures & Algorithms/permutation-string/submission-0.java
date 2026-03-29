// Solution using sliding window and Map
// It does not use the concept of only 26 chars in alphabet.
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        var map1 = new HashMap<Character, Integer>();
        var map2 = new HashMap<Character, Integer>();
        for(int i=0; i<s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if(map1.equals(map2)) return true;

        for(int i=s1.length(); i<s2.length(); i++) {
            char charToAddToWindow = s2.charAt(i);
            char charToRemoveFromWindow = s2.charAt(i-s1.length());
            map2.put(charToAddToWindow, map2.getOrDefault(charToAddToWindow, 0) + 1);
            map2.put(charToRemoveFromWindow, map2.get(charToRemoveFromWindow)-1);
            
            if (map2.get(charToRemoveFromWindow) == 0)
                 map2.remove(charToRemoveFromWindow);

            if(map1.equals(map2))
                return true;
        }
        
        return false;
    }
}
