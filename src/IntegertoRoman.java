import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegertoRoman {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            String ret = new IntegertoRoman().intToRoman(num);

            String out = (ret);

            System.out.print(out);
        }
    }

    public String intToRoman(int num) {

        int thousands = num / 1000;
        int hundreds = (num - 1000 * thousands) / 100;
        int tens = (num - 1000 * thousands - 100 * hundreds) / 10;
        int ones = (num - 1000 * thousands - 100 * hundreds - 10 * tens);

        StringBuilder romanBuilder = new StringBuilder();
        for (int i = 0; i < thousands; i++) {
            romanBuilder.append("M");
        }

        if (hundreds == 9) {
            romanBuilder.append("CM");
        } else if (hundreds >= 5) {
            romanBuilder.append("D");
            for (int i = 0; i < hundreds - 5; i++) {
                romanBuilder.append("C");
            }
        } else if (hundreds == 4) {
            romanBuilder.append("CD");
        } else {
            for (int i = 0; i < hundreds; i++) {
                romanBuilder.append("C");
            }
        }

        if (tens == 9) {
            romanBuilder.append("XC");
        } else if (tens >= 5) {
            romanBuilder.append("L");
            for (int i = 0; i < tens - 5; i++) {
                romanBuilder.append("X");
            }
        } else if (tens == 4) {
            romanBuilder.append("XL");
        } else {
            for (int i = 0; i < tens; i++) {
                romanBuilder.append("X");
            }
        }

        if (ones == 9) {
            romanBuilder.append("IX");
        } else if (ones >= 5) {
            romanBuilder.append("V");
            for (int i = 0; i < ones - 5; i++) {
                romanBuilder.append("I");
            }
        } else if (ones == 4) {
            romanBuilder.append("IV");
        } else {
            for (int i = 0; i < ones; i++) {
                romanBuilder.append("I");
            }
        }

        return romanBuilder.toString();
    }
}
