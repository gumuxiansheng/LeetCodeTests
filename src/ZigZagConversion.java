import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZigZagConversion {
    public static String stringToString(String input) {
        return input.replace("\"", "");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            int numRows = Integer.parseInt(line);

            String ret = new ZigZagConversion().convert(s, numRows);

            String out = (ret);

            System.out.print(out);
        }
    }

    public String convert(String s, int numRows) {
        if (numRows == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        int[] columnIndexes = new int[length];
        char[] originChars = s.toCharArray();
        char[] resultChars = new char[length];

        int k = 0;
        for (int i = 0; i < length; i++) {
            int circleIndex = (i / (2 * numRows - 2));
            int innerStartIndex = i - circleIndex * (2 * numRows - 2);
            int rowIndex;
            if (innerStartIndex < numRows) {
                rowIndex = innerStartIndex;
            } else {
                rowIndex = numRows - (innerStartIndex - (numRows - 1)) - 1;
            }
            columnIndexes[k++] = rowIndex;
        }

        k = 0;
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < length; i++) {
                if (columnIndexes[i] == j) {
                    resultChars[k++] = originChars[i];
                }
            }

        }

        return new String(resultChars);
    }

}
