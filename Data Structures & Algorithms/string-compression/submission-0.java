class Solution {
    public int compress(char[] chars) {
        var writeIdx = 0; var readIdx = 0;
        while(readIdx < chars.length) {
            chars[writeIdx] = chars[readIdx];
            writeIdx++;
            var recurringCharIdx = readIdx + 1;
            // Update readIdx if duplicate chars exists.
            while(recurringCharIdx < chars.length && chars[readIdx] == chars[recurringCharIdx]) 
                recurringCharIdx++;
            
            // If duplicate chars exist
            if(recurringCharIdx - readIdx >1) {
                var count = String.valueOf(recurringCharIdx - readIdx);
                for(char c : count.toCharArray()) {
                    chars[writeIdx++] = c;
                }
            }
            readIdx = recurringCharIdx;
        }
        return writeIdx;
    }
}