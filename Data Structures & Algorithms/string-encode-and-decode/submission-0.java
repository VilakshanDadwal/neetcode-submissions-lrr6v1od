class Solution {

    public String encode(List<String> strs) {
        var result = new StringBuilder();
        for(String s: strs) {
            result.append(s.length()).append('#').append(s);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        var result = new ArrayList<String>();
        var i=0;
        while(i < str.length()) {
            var j = i;
            while(str.charAt(j) !='#') j++;
            var lengthOfCurrentString = Integer.parseInt(str.substring(i,j));
            i=j+1; // Setting i to start of current string having length as lengthOfCurrentString .
            j = i + lengthOfCurrentString; // Setting j to end of current string.
            result.add(str.substring(i, j));
            i = j; // Setting i to length of next string.
        }
        return result;
    }
}
