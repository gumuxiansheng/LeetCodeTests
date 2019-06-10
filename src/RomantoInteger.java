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
            switch (romanChars[i]) {
                case 'I':
                    if (i < romanChars.length - 1 && romanChars[i + 1] == 'V') {
                        intNum += 4;
                        i++;
                    } else if (i < romanChars.length - 1 && romanChars[i + 1] == 'X') {
                        intNum += 9;
                        i++;
                    } else {
                        intNum++;
                    }

                    break;
                case 'V':
                    intNum += 5;
                    break;
                case 'X':
                    if (i < romanChars.length - 1 && romanChars[i + 1] == 'L') {
                        intNum += 40;
                        i++;
                    } else if (i < romanChars.length - 1 && romanChars[i + 1] == 'C') {
                        intNum += 90;
                        i++;
                    } else {
                        intNum += 10;
                    }
                    break;
                case 'L':
                    intNum += 50;
                    break;
                case 'C':
                    if (i < romanChars.length - 1 && romanChars[i + 1] == 'D') {
                        intNum += 400;
                        i++;
                    } else if (i < romanChars.length - 1 && romanChars[i + 1] == 'M') {
                        intNum += 900;
                        i++;
                    } else {
                        intNum += 100;
                    }
                    break;
                case 'D':
                    intNum += 500;
                    break;
                case 'M':
                    intNum += 1000;
                    break;
            }
        }

        return intNum;
    }
}
