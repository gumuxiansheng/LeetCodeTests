import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (36.87%)
 * Total Accepted:    53.9K
 * Total Submissions: 146.1K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
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

