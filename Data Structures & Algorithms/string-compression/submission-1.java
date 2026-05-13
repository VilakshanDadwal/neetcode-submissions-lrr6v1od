class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char current = chars[read];
            int start = read;
            // Count occurrences
            while (read < chars.length && chars[read] == current) {
                read++;
            }
            int count = read - start;
            // Write character
            chars[write++] = current;
            // Write count if > 1
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}