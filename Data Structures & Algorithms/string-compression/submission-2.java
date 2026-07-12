class Solution {
    public int compress(char[] chars) {
        var write = 0; 
        var left =0;
        var right = 0;
        while(right < chars.length) {
            // Identify the curretn char to write and how many times to write
            var currentChar = chars[right];
            while(right < chars.length && currentChar == chars[right]) {
                right++;
            }
            var count = right - left;

            // Now write the char and the count for it.
            chars[write++] = currentChar;
            if(count > 1) {
                var currentCount = String.valueOf(right - left);
                for(char c: currentCount.toCharArray()) {
                    chars[write++] = c;
                }
            }
            left = right;
        }
        return write;
    }
}