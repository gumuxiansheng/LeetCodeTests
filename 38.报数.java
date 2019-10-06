/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String tempStr = "1";

        for (int i = 1; i < n; i++){
            tempStr = countAndSay(tempStr);
        }
        
        return tempStr;
        
    }
    
    public String countAndSay(String numStr) {
        if (numStr.length() == 1){
            return "11";
        }
        char[] numChars = numStr.toCharArray();
        StringBuilder numBuilder = new StringBuilder();
        
        int anchor = 0;
        for (int i = 1; i < numChars.length; i++) {
            if ((numChars[i] != numChars[i-1])){
                numBuilder.append((i-anchor) + "" + numChars[i-1]);
                anchor = i;
            }
            
            if(i == numChars.length -1){
                numBuilder.append((i - anchor + 1) + "" + numChars[i]);
            }
            
        }
        
        return numBuilder.toString();
    }
}
// @lc code=end

