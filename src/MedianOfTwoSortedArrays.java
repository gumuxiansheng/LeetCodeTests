import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class MedianOfTwoSortedArrays {
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

    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);

            double ret = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);

            String out = doubleToString(ret);

            System.out.print(out);
        }
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        boolean isEven = ((m + n) % 2 == 0);
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2; // make the first part equal(m+n is even) to or 1 larger(m+n is odd) than the second
        if (m == 0) {
            return isEven ? (B[n - 1] + B[0]) / 2f : B[halfLen - 1];
        }

        while (iMin <= iMax) { // quick search the valid i
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i > iMin && A[i - 1] > B[j]) { // i is too big
                iMax = i - 1;
                continue;
            }

            if (i < iMax && B[j - 1] > A[i]) { // i is too small
                iMin = i + 1;
                continue;
            }

            if (i == 0) { // the appropriate number (edge)
                return isEven ? (B[j - 1] + (j == n ? A[i] : Math.min(A[i], B[j]))) / 2f : B[j - 1];
            } else if (i == m) {
                return isEven ? ((j == 0 ? A[i - 1] : Math.max(A[i - 1], B[j - 1])) + B[j]) / 2f : (j == 0 ? A[i - 1] : Math.max(A[i - 1], B[j - 1]));
            }

            if (j == 0) { // the appropriate number (edge)
                return isEven ? (A[i - 1] + Math.min(A[i], B[j])) / 2f : A[i - 1];
            } else if (j == n) {
                return isEven ? (Math.max(A[i - 1], B[j - 1]) + A[i]) / 2f : Math.max(A[i - 1], B[j - 1]);
            }

            if (A[i - 1] <= B[j] && B[j - 1] <= A[i]) { // the appropriate number
                return isEven ? (float) (Math.max(A[i - 1], B[j - 1]) + Math.min(A[i], B[j])) / 2f : Math.max(A[i - 1], B[j - 1]);
            }

        }

        return 0.0;
    }
}
