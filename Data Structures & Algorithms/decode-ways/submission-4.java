// Bottom Up
class Solution {
    public int numDecodings(String s) {
        var nums = new HashSet<String>();
        for(int i=1; i<=26; i++) {
            nums.add(String.valueOf(i));
        }

        var ways = new int[s.length()+1];
        ways[ways.length-1] = 1;
        if(s.charAt(s.length()-1) != '0')
            ways[ways.length-2] = 1;
        
        for(int i=ways.length-3; i>=0; i--) {
            if(s.charAt(i) != '0') {
                ways[i] = ways[i+1];
            }
            if(i < ways.length-2 && nums.contains(s.substring(i,i+2))) {
              ways[i] += ways[i+2];
            }
        }
        return ways[0];
    }
}
