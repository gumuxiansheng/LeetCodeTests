import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
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
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new ThreeSumClosest().threeSumClosest(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int currentClosest = nums[0] + nums[1] + nums[2];
        int closestLength = Math.abs(currentClosest);
        FIRST:
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target && nums[i] - target > closestLength) {
                break;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] > target && nums[i] + nums[j] - target > closestLength) {
                    continue FIRST;
                }

                // binary search
                int low = j + 1;
                int high = nums.length - 1;
                int key = target - nums[i] - nums[j];

                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    int midVal = nums[mid];

                    if (midVal < key)
                        low = mid + 1;
                    else if (midVal > key)
                        high = mid - 1;
                    else
                        return target; // target found, so the closest number should be the target since its distance is 0

                }

                // target not found, compare the left and right side and choose the closer.
                int tempClosest = nums[i] + nums[j] + nums[Math.max(j + 1, high)];
                if (Math.abs(target - nums[i] - nums[j] - nums[Math.min(nums.length - 1, low)]) < Math.abs(target - tempClosest)) {
                    tempClosest = nums[i] + nums[j] + nums[Math.min(nums.length - 1, low)];
                }

                if (Math.abs(target - tempClosest) < Math.abs(target - currentClosest)) {
                    currentClosest = tempClosest;
                    closestLength = Math.abs(currentClosest);
                }

            }
        }
        return currentClosest;
    }

}
