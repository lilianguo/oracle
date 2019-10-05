/*
44. Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
*/

// time complexity: O(mn) where n m 是两个string的长度，
// 使用了记忆化搜索以后（memoization），时间复杂度是 O(nm)，n和m是两个字符串的长度。因为对于我们要记忆的东西（也就是搜索函数里的参数组合）一共就 O(nm) 种可能性。
// 每种参数组合的可能性往下递归的时候，是 O(1) 的处理时间。
class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        // memo[i][j] 用一个二维的 boolean 数组来当记忆化数组，记录 s 从 sIndex 开始的后缀 能够匹配上 p 从 pIndex 开始的后缀
        // visited[i][j] 记录 s 从 sIndex 开始的后缀 和 p 从 pIndex 开始的后缀这个组合是否访问过
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return helper(s, p, 0, 0, memo, visited);
    }

    // return if s 从 sIndex 开始的后缀 能够匹配上 p 从 pIndex 开始的后缀
    private boolean helper(String string, String pattern, int sIndex, int pIndex, boolean[][] memo, boolean[][] visited) {
        // deal with 出口
        // 如果 p 从pIdex开始是空字符串了，那么 s 也必须从 sIndex 是空才能匹配上
        if (pIndex == pattern.length()) {
            return sIndex == string.length();
        }
        // 如果 s 从 sIndex 是空，那么p 必须全是 * 
        if (sIndex == string.length()) {
            for (int index = pIndex; index < pattern.length(); index++) {
                if (pattern.charAt(index) != '*') {
                    return false;
                }
            }
            return true;
        }

        // deal with next iteration

        // 如果当前组合已经visit过了， 直接return memo里的结果
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        
        // compare current character, see if it matches
        char sChar = string.charAt(sIndex);
        char pChar = pattern.charAt(pIndex);
        boolean match;

        // 如果pattern 是 *， 那么它可以匹配当前s,或者选择为空
        if (pChar == '*') {
            match = helper(string, pattern, sIndex + 1, pIndex, memo, visited) 
                    || helper(string, pattern, sIndex, pIndex + 1, memo, visited);
        } else {
            // 如果不是 *，当前字符要匹配，且后面的串也匹配才可以
            match = charMatch(sChar, pChar) &&
                    helper(string, pattern, sIndex + 1, pIndex + 1, memo, visited);
        }

        // 上面recursively 解决了之后就可以得到整个字符串的visited 和 memo， 然后return就好了
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }
    
    private boolean charMatch(char s, char p) {
        return (s == p || p == '?');
    }
}