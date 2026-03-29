// Bottom Up - Space Optmised - 2 Array
class Solution {
    public int numDistinct(String s, String t) {
        if(t.length() > s.length()) return 0;
        var previous = new int[t.length()+1];
        var current = new int[t.length()+1];

        current[t.length()] = previous[t.length()] = 1;

        for(int i=s.length()-1; i>=0; i--) {
            for(int j=t.length()-1; j>=0; j--) {
                current[j] = previous[j];
                if(s.charAt(i) == t.charAt(j)) {
                    current[j] += previous[j+1];
                }
            }
            int[] temp = previous;
            previous = current;
            current = temp;

            Arrays.fill(current, 0);
            current[t.length()] = 1;
        }
        return previous[0];
    }
}
