class Solution {
    public String decodeString(String s) {
        var stringStack = new Stack<String>();
        var timeToRepeatStack = new Stack<Integer>();
        var subString = new StringBuilder();

        var num = 0;
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                // c-0 to convert current char to integer.
                // This is a way to create the number , by going through digit chars one by one
                // We multipel existing value by 10 to move its place by power of 10
                // and then add current char as integer.
                num = num*10 + (c-'0');
            } else if(c =='[') {
                // add current number and string to respective stack.
                stringStack.push(subString.toString());
                timeToRepeatStack.push(num);
                subString = new StringBuilder();
                num = 0;
            } else if(c ==']') {
                var temp = subString.toString();
                subString = new StringBuilder(stringStack.pop());
                var timeToRepeat = timeToRepeatStack.pop();
                for(int i =0; i < timeToRepeat; i++) {
                    subString.append(temp);
                }
            } else {
                subString.append(c);
            }
        }
        return subString.toString();
    }
}