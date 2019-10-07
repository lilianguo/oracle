/*
224. Basic Calculator
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
non-negative integers and empty spaces

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.

*/
class BasicCalculator {
    // TLE
    public int calculate(String s) {
        String expression = s.trim();
        if (s == null || expression.length() == 0) {
            return 0;
        }
        // 用stack 压 
        Stack<String> stack = new Stack<>();
        stack.push(expression.charAt(0) + "");
        int sum = 0;
        String sign = "+";
        String num = "";
        int i = 1;
        for (; i < expression.length(); i++) {
            // push until we see a ")"
            while(expression.charAt(i) != ')') {
                stack.push(expression.charAt(i) + "");
                i++;
            }

            // a ")" is currently sitting at expression.charAt(i)
            // pop to perform add
            while(!stack.peek().equals("(")) {
                if (isNum(stack.peek())) {
                    num = stack.pop() + num;
                } else {
                    if (stack.peek().equals("+")) {
                        sum += Integer.parseInt(num);
                    } else {
                        sum -= Integer.parseInt(num);
                        sign = sum > 0 ? "+" : "-";
                        sum = Math.abs(sum);
                    }
                    num = "";
                }
            }
            stack.pop();
            // see if now the peed with sum is +- -- ++ -+
            if (!stack.isEmpty()) {
                if (stack.peek().equals(sign)) {
                    stack.push(sum);
                } else {
                    stack.pop();
                    stack.push("-");
                    stack.push(sum);
                }
            }
        }

        while (!stack.isEmpty()) {
            if (isNum(stack.peek())) {
                num = stack.pop() + num;
            } else {
                if (stack.peek().equals("+")) {
                    sum += Integer.parseInt(num);
                } else {
                    sum -= Integer.parseInt(num);
                }
                num = "";
            }
            stack.pop();
        }
        return sum;
    }


    /*
    处理多位整数。比如解析123，第一次循环为 1 * 10 + 2 = 12，第二次循环为 12 * 10 + 3 = 123；
    处理加减号。不是存储入到操作符栈，而是转为正负号，待到下一次循环时，与前面的累计结果进行相加；
    处理括号。如果遇到 左括号 (，就将前面累计的结果与正负存储操作数栈，并将累计结果清空，正负号标记为正。等到遇到右括号 )时，就将这一次累计的结果与操作数栈顶存储的累计结果进行累加，得到一个最终结果；
    */
    // accepted
    public int calculateII(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        // use two stacks to deal with bracelets
        // save the number and signs before the bracelet so that when we reach ), we can perform +-*/ between *  for 2 * (2 + 3) (it becomes 2 * 5)
        Stack<Integer> values = new Stack<>();
        Stack<Integer> signs = new Stack<>();
        int res = 0, num = 0, sign = 1;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num* 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                res += sign * num;
                num = 0;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                values.push(res);
                res = 0;
                signs.push(sign);
                sign = 1;
            } else if (s.charAt(i) == ')') {
                res *= signs.pop();
                res += values.pop();
            }
        } 
        return res;
    }
}