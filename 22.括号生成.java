import java.util.HashMap;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesisList = new ArrayList<>();
        if (n == 1) {
            parenthesisList.add("()");
            return parenthesisList;
        }
        if (n == 2) {
            parenthesisList.add("()()");
            parenthesisList.add("(())");
            return parenthesisList;
        }

        List<String> iteratedParenthesis = generateParenthesis(n - 1);
        Set<String> set = new HashSet<String>();
        for (String parenthesis : iteratedParenthesis) {
            for (int i = 1; i < parenthesis.length(); i++) {
                // we needn't "()-" and "-()" because every n-1 > 1 will generate "()-" and
                // "-()" so adding "()" between "()" and "-" can reach the same result.
                StringBuffer parenthesisBuffer = new StringBuffer(parenthesis);
                parenthesisBuffer.insert(i, "()");
                set.add(parenthesisBuffer.toString());
            }

            set.add("(" + parenthesis + ")");

        }
        parenthesisList = new ArrayList<String>(set);

        return parenthesisList;
    }
}
