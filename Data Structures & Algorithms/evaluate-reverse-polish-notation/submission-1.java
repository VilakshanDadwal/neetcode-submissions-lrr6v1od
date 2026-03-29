class Solution {
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();
        var operators = new HashSet<String>();

        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for(String token: tokens) {
            if(!operators.contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            var operator = token;
            var second = stack.pop();
            var first = stack.pop();

            var result = apply(operator, first, second);
            stack.push(result);
        }
        return stack.peek();
    }

    int apply(String operator, int first, int second) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}
