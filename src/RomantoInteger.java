import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomantoInteger {
    public static String stringToString(String input) {
        return input.replace("\"", "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new RomantoInteger().romanToInt(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public int romanToInt(String s) {
//        String[] romanDefChars = {"I", "V", "X", "L", "C", "D", "M", "CM", "CD", "XL", "XC", "IV", "IX"};

        char[] romanChars = s.toCharArray();
        int intNum = 0;
        for (int i = 0; i < romanChars.length; i++) {
            if (romanChars[i] == 'I'){
                if (i < romanChars.length - 1 && romanChars[i + 1] == 'V') {
                    intNum += 4;
                    i++;
                } else if (i < romanChars.length - 1 && romanChars[i + 1] == 'X') {
                    intNum += 9;
                    i++;
                } else {
                    intNum++;
                }

            } else if (romanChars[i] == 'V') {
                intNum += 5;
            } else if (romanChars[i] == 'X') {
                if (i < romanChars.length - 1 && romanChars[i + 1] == 'L') {
                    intNum += 40;
                    i++;
                } else if (i < romanChars.length - 1 && romanChars[i + 1] == 'C') {
                    intNum += 90;
                    i++;
                } else {
                    intNum += 10;
                }
            } else if (romanChars[i] == 'L') {
                intNum += 50;
            } else if (romanChars[i] == 'C') {
                if (i < romanChars.length - 1 && romanChars[i + 1] == 'D') {
                    intNum += 400;
                    i++;
                } else if (i < romanChars.length - 1 && romanChars[i + 1] == 'M') {
                    intNum += 900;
                    i++;
                } else {
                    intNum += 100;
                }
            } else if (romanChars[i] == 'D') {
                intNum += 500;
            } else if (romanChars[i] == 'M') {
                intNum += 1000;
            }
        }

        return intNum;
    }
}
