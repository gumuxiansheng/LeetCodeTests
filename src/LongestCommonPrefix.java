import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonPrefix {
    public static String[] stringToStringArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new String[0];
        }

        String[] parts = input.split(",");
        String[] output = new String[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = part.substring(1, part.length() - 1);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] strs = stringToStringArray(line);

            String ret = new LongestCommonPrefix().longestCommonPrefix(strs);

            String out = (ret);

            System.out.print(out);
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder commonPrefixBuilder = new StringBuilder();
        String strNo1 = strs[0];
        for (int i = 0; i < strNo1.length(); i++) {
            char initialChar = strNo1.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i +1 || strs[j].charAt(i) != initialChar){
                    return commonPrefixBuilder.toString();
                }
            }
            commonPrefixBuilder.append(initialChar);
        }
        return commonPrefixBuilder.toString();
    }
}
