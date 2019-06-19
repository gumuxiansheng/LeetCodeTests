/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();

        int wlen = words[0].length();
        int len = wlen * words.length;

        for (int i = 0; i < s.length() - len + 1; i++) {
            List<String> exWords = new ArrayList<>(Arrays.asList(words));
            for (int j = 0; j < words.length; j++) {
                String word = s.substring(i + j * wlen, i + j * wlen + wlen);
                if (exWords.contains(word)) {
                    exWords.remove(word);
                } else {
                    break;
                }
            }
            if (exWords.isEmpty()){
                result.add(i);
            }
        }

        return result;
    }
}
