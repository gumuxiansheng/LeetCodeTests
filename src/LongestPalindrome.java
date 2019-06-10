import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindrome {

    public static String stringToString(String input) {
        return input.replace("\"", "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            String ret = new LongestPalindrome().longestPalindrome(s);

            String out = (ret);

            System.out.print(out);
        }
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        char[] sChars = s.toCharArray();
        boolean isValid = false;

        for (int i = length; i > 0; i--) {
            for (int leftIndex = 0; leftIndex <= length - i; leftIndex++) {
                for (int step = 0; step < i / 2; step++) {
                    if (sChars[leftIndex + step] != sChars[leftIndex + i - 1 - step]) {
                        break;
                    }
                    if (step == i / 2 - 1) {
                        isValid = true;
                    }
                }
                if (isValid) {
                    return new String(sChars, leftIndex, i);
                }
            }
        }

        return s.substring(0, 1);
    }
}
