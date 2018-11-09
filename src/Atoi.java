import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Atoi {
    public static String stringToString(String input) {
        return input.replace("\"", "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String str = stringToString(line);

            int ret = new Atoi().myAtoi(str);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public int myAtoi(String str) {

        char[] strChars = str.toCharArray();

        boolean isNegative = false;
        boolean started = false;
        int result = 0;
        for (int i = 0; i < strChars.length; i++) {
            if (!started) {
                if (strChars[i] == 43 || strChars[i] == 45) {
                    isNegative = (strChars[i] == 45);
                    started = true;
                    continue;
                } else if ((strChars[i] <= 57 && strChars[i] >= 48)) {
                    started = true;
                } else if (strChars[i] == 32) {
                    continue;
                } else {
                    return 0;
                }
            }

            if (strChars[i] <= 57 && strChars[i] >= 48) {
                if (isNegative ? ((0 - result) < (Integer.MIN_VALUE / 10)) : result > (Integer.MAX_VALUE / 10)) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                if (isNegative ? (((0 - result) == (Integer.MIN_VALUE / 10)) && strChars[i] > 56) : ((result == (Integer.MAX_VALUE / 10)) && strChars[i] > 55)) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result = result * 10 + (strChars[i] - 48);
            } else {
                return isNegative ? (0 - result) : result;
            }

        }

        return isNegative ? (0 - result) : result;
    }
}
