import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;

public class RegularExpressionMatching {
    public static String stringToString(String input) {
        return input.replace("\"", "");
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String p = stringToString(line);

            boolean ret = new RegularExpressionMatching().isMatch(s, p);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

    public boolean isMatch(String s, String p) {
        boolean isMatch = Pattern.matches(p, s);

        char[] stringChars = (s + "$").toCharArray();
        char[] patternCharsOrigin = (p + "$").toCharArray();

        StringBuilder patternCharsBuilder = new StringBuilder();

        // normalize
        for (int i = 0; i < patternCharsOrigin.length; i++) {
            if (i > 1 && i < patternCharsOrigin.length - 1 && patternCharsOrigin[i + 1] == '*' && patternCharsOrigin[i - 1] == '*' && patternCharsOrigin[i - 2] == patternCharsOrigin[i]) {
                i++;
                continue;
            }
            patternCharsBuilder.append(patternCharsOrigin[i]);

        }

        char[] patternChars = patternCharsBuilder.toString().toCharArray();

        int[] passIIndexStack = new int[stringChars.length];
        int[] passJIndexStack = new int[patternChars.length];
        int passIIndex = -1;
        int passJIndex = -1;


        int i = 0, j = 0;
        int stackIndex = -1;
        for (; i < stringChars.length && j < patternChars.length; i++, j++) {
//            System.out.println("i = " + i + "; j = " + j);
            // * start
            if (j < patternChars.length - 1 && patternChars[j + 1] == '*') {
                if (patternChars[j] == '*') {
//                    System.out.println("false1");
                    return false;
                }
                boolean isStackPushed = false;
                while (j < patternChars.length - 2 && patternChars[j + 1] == '*' && (passIIndex != i || passJIndex != j)) {
                    if (patternChars[j] == stringChars[i] || patternChars[j] == '.') {
                        // push stack
                        stackIndex++;
                        passIIndexStack[stackIndex] = i;
                        passJIndexStack[stackIndex] = j;
//                        System.out.println("stackIndex++: " + stackIndex + "; passIIndex: " + passIIndex + "; passJIndex: " + passJIndex);
                        isStackPushed = true;
                    }
                    j += 2;
                }

                if (isStackPushed) {
                    i--;
                    j--;
                    continue;
                }else if (stringChars[i] == patternChars[j] || patternChars[j] == '.') {
                    continue;
                } else { // no match
                    i--;
                    j--;
                    continue;
                }
            } else if (stringChars[i] == patternChars[j] || (patternChars[j] == '.' && stringChars[i] != '$')) {
                // match
                continue;
            } else if (j > 0 && patternChars[j] == '*' && (stringChars[i] == patternChars[j - 1] || patternChars[j - 1] == '.')) {
                i--;
                j-=2;
                continue;
            } else if (j > 0 && patternChars[j] == '*' && stringChars[i] != patternChars[j - 1] && patternChars[j - 1] != '.') { // match 0 times
                i--;
                continue;
            } else {
                if (stackIndex >= 0) {
                    // pop stack
                    passIIndex = passIIndexStack[stackIndex];
                    passJIndex = passJIndexStack[stackIndex];
                    i = passIIndex - 1;
                    j = passJIndex - 1;

                    passIIndexStack[stackIndex] = 0;
                    passJIndexStack[stackIndex] = 0;
                    stackIndex--;
//                    System.out.println("stackIndex--: " + stackIndex + "; passIIndex: " + passIIndex + "; passJIndex: " + passJIndex);
                    continue;
                }
                return false;
            }
        }

        if (j < patternChars.length && patternChars[j] == '*') {
            j++;
        }


        NEXT:for (int k = 0; k < 10; k++) {

            i = 1;
            i = 2;
            i = 3;

            continue NEXT;

        }


        return (i == stringChars.length) && (j == patternChars.length);
    }

}
