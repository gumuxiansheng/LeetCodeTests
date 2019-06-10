import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (35.96%)
 * Total Accepted:    526.6K
 * Total Submissions: 1.5M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Stack<Character> bracketsStack = new Stack<Character>();
        char[] bracketChars = new char[] { '(', ')', '{', '}', '[', ']' };
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            for (int j = 0; j < 6; j += 2) {
                if (sChar == bracketChars[j]) {
                    bracketsStack.push(sChar);
                    break;
                }

            }
            for (int j = 1; j < 6; j += 2) {
                if (sChar == bracketChars[j]) {
                    if (bracketsStack.isEmpty()) {
                        return false;
                    }
                    if (bracketsStack.peek() == bracketChars[j - 1]) {
                        bracketsStack.pop();
                        break;
                    } else {
                        return false;
                    }
                }

            }
        }
        return bracketsStack.isEmpty();
    }
}
