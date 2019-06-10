import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainerWithMostWater {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] height = stringToIntegerArray(line);

            int ret = new ContainerWithMostWater().maxArea(height);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                int current;
                if (height[i] > height[j]) {
                    current = (i - j) * height[j];
                } else {
                    current = (i - j) * height[i];
                }
                if (current > max) {
                    max = current;
                }
            }
        }

        return max;
    }
}
