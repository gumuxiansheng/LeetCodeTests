import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new ReversInteger().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public int reverse(int x) {
        int digits;
        for (digits = 0; digits < 12; digits++) {
            if (x >= 0) {
                if (x < (Math.pow(10, digits))) {
                    break;
                }
            } else {
                if (x > -(Math.pow(10, digits))) {
                    break;
                }
            }
        }

        int result = 0;
        int priorResult = 0;
        for (int i = digits; i > 0; i--) {
            result += (int) (x / (Math.pow(10, i - 1))) * (Math.pow(10, digits - i));
            if (result - priorResult != (int) (x / (Math.pow(10, i - 1))) * (Math.pow(10, digits - i))) {
                return 0;
            }
            priorResult = result;
            x -= (int) (((int) (x / Math.pow(10, i - 1))) * Math.pow(10, i - 1));
        }
        return result;
    }
}
