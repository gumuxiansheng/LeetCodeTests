import java.util.ArrayList;
import java.util.HashMap;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (48.02%)
 * Total Accepted:    17.7K
 * Total Submissions: 36.8K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        /* a-z ascii: 97-122
           2-50:a,b,c-97,98,99
           3-51:d,e,f-100,101,102
           4-52:g,h,i-103,104,105
           5-53:j,k,l-106,107,108
           6-54:m,n,o-109,110,111
           --- +3*('char' - '2') + 47\48\49
           7-55:p,q,r,s-112,113,114,115
           --- +3*('char' - '2') + 47\48\49\50
           8-56:t,u,v-116,117,118
           --- +3*('char' - '2') + 1 + 47\48\49
           9-57:w,x,y,z-119,120,121,122
           --- +3*('char' - '2') + 1 + 47\48\49\50
         */
        int resultsLen = 1;
        // int[] charCategories = new int[digits.length()];
        int[] charCategoriesMult = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '8':
                    // charCategories[i] = 3;
                    resultsLen *= 3;
                    charCategoriesMult[i] = resultsLen;
                    break;
                case '7':
                case '9':
                    // charCategories[i] = 4;
                    resultsLen *= 4;
                    charCategoriesMult[i] = resultsLen;
                    break;
                default:
                    break;
            }
        }
        if (resultsLen == 1) {
            return new ArrayList<>();
        }

        // List<String> results = new ArrayList<>(resultsLen);
        String[] resultsStrings = new String[resultsLen];
        for (int i = 0; i < digits.length(); i++) {
            for (int j = 0; j < charCategoriesMult[i]; j++){
                if (resultsStrings[j] == null) {
                    resultsStrings[j] = new String();
                }
                if (i == 0){
                    switch (digits.charAt(i)) {
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                            resultsStrings[j] = "" + (char)('2' + 3*(digits.charAt(i) - '2') + 47 + j);
                            break;
                        case '8':
                        case '9':
                            resultsStrings[j] = "" + (char)('2' + 3*(digits.charAt(i) - '2') + 1 + 47 + j);
                            break;
                        default:
                            break;
                    }
                } else {
                    String temp = resultsStrings[j % charCategoriesMult[i - 1]];
                    switch (digits.charAt(i)) {
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                            resultsStrings[j] = (temp.length() > i ? temp.substring(0, i) : temp) + (char)('2' + 3*(digits.charAt(i) - '2') + 47 + (j / charCategoriesMult[i - 1]));
                            break;
                        case '8':
                        case '9':
                            resultsStrings[j] = (temp.length() > i ? temp.substring(0, i) : temp) +(char)('2' + 3*(digits.charAt(i) - '2') + 1 + 47 + (j / charCategoriesMult[i - 1]));
                            break;
                        default:
                            break;
                    }
                }
            }
            
        }
        
        return Arrays.asList(resultsStrings);
    }
}

