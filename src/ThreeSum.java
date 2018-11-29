import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<List<Integer>> ret = new ThreeSum().threeSum(nums);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sortedTriplets = new ArrayList<>();
        FIRST:
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            List<Integer> candidates = new ArrayList<>();
            candidates.add(nums[i]);
            SECOND:
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] > 0) {
                    continue FIRST;
                }
                for (int i1 = sortedTriplets.size() - 1; i1 >= 0; i1--) {
                    List<Integer> storedTriple = sortedTriplets.get(i1);
                    if (storedTriple.get(0).equals(candidates.get(0)) && storedTriple.get(1).equals(nums[j])) {
                        continue SECOND;
                    }
                    if (!candidates.get(0).equals(storedTriple.get(0))) {
                        break;
                    }
                }
                candidates.add(nums[j]);
                int index = Arrays.binarySearch(nums, j + 1, nums.length, 0 - nums[i] - nums[j]);
                if (index >= 0 && index < nums.length) {
                    candidates.add(nums[index]);
                    sortedTriplets.add(new ArrayList<>(candidates));
                    candidates.remove(1);
                    candidates.remove(1);
                } else {
                    candidates.remove(1);
                }
            }
        }
        return sortedTriplets;
    }

}
