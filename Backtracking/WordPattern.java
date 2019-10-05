import java.util.Map;

/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
*/
class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.trim().split(" ");
        System.out.println("strs.length: " + strs.length);
        System.out.println("pattern.length() " + pattern.length());
        if ((pattern.length() == 0 || pattern == null ) && strs.length > 0) {
            return false;
        }
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<Character, String> patternToStr = new HashMap<>();
        Set<String> visited =  new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            String string = strs[i];
            Character key = pattern.charAt(i);
            System.out.println("i " + i);
            System.out.println("key " + pattern.charAt(i));
            System.out.println("string " + strs[i]);
            if (!patternToStr.containsKey(key)){
                if (visited.contains(string)) {
                    return false;
                }
                patternToStr.put(pattern.charAt(i), string);
                visited.add(string);
                continue;
            }
            if (patternToStr.containsKey(key) && !patternToStr.get(key).equals(string)) {
                return false;
            }
        }
        return true;
    }
}