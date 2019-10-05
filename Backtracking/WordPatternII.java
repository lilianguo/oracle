import java.util.Map;

/*
291. Word Pattern II

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Example 1:

Input: pattern = "abab", str = "redblueredblue"
Output: true
Example 2:

Input: pattern = "aaaa", str = "asdasdasdasd"
Output: true
Example 3:

Input: pattern = "aabb", str = "xyzabcxzyabc"
Output: false
Notes:
You may assume both pattern and str contains only lowercase letters.
*/
class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return helper(pattern, str, set, map);
    }


    /**
     *  return if the remaining pattern with the remaining str could be legal
     * @param pattern remaining un-traversed pattern
     * @param str remaining un-traversed str
     * @param set a HashSet to keep all traversed word
     * @param map  a HashMap mapping pattern char to String word
     * @return return if the remaining pattern with the remaining str could be legal
     */
    private boolean helper(String pattern, String str, Set<String> set, Map<Character, String> map) {
        // if pattern has finished traversing and there's nothing left, the input would then be illegal if the remaining string is not empty
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        // get the current pattern we're traversing
        Character c = pattern.charAt(0);

        // if we've met this pattern, the input would be invalid if the remaining string does not start with the corresponding word in map for key c
        if (map.containsKey(c)) {
            if (!str.startsWith(map.get(c))) {
                return false;
            }
            // otherwise, validating illegal depends on the remaining part of the string and pattern
            return helper(pattern.substring(1), str.substring(map.get(c).length()), set, map);
        }

        // if this pattern has not been met before, we need to try every len of the corresponding word to see if it's gonna be valid or not
        for (int i = 0; i < str.length(); i++) {
            String word = str.substring(0, i + 1);
            if (set.contains(word)) {
                continue;
            }
            map.put(c, word);
            set.add(word);
            if (helper(pattern.substring(1), str.substring(i + 1), set, map)) {
                return true;
            }
            map.remove(c);
            set.remove(word);
        }
        return false;
    }
}