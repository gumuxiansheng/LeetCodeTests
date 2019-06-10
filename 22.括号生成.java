import java.util.HashMap;
import java.util.List;

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
        
        List<String> iteratedParenthesis = generateParenthesis(n-1);
        for (String parenthesis : iteratedParenthesis) {
            for (int i = 0; i < parenthesis.length(); i++) {
                StringBuffer parenthesisBuffer = new StringBuffer(parenthesis);
                parenthesisBuffer.insert(i, "()");
                if (!parenthesisList.contains(parenthesisBuffer.toString())) {
                    parenthesisList.add(parenthesisBuffer.toString());
                }
            }

            if (!parenthesisList.contains("(" + parenthesis + ")")) {
                parenthesisList.add("(" + parenthesis + ")");
            }
            
        }

        return parenthesisList;
    }
}

