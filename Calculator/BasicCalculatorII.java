/*
227. Basic Calculator II
https://www.jianshu.com/p/a69e8722c493 
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
*/
class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // take 2*3 + 5 as example, op represents the operation for current number
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (i == s.length() - 1 || (!Character.isDigit(c)&& c != ' ' )) {
                // 1. perfrom  + 2
                // 5. perfrom +5
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    // 3. perfrom 2*3
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                // update op to represent the operation for next showing num
                // 2. update op = * for 3
                // 4. update op = + for 5
                op = c;
                num = 0;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}