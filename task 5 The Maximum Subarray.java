import java.util.*;

public class Solution {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int maxSubarray = arr.get(0);
        int current = arr.get(0);

        int maxSubsequence = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            int value = arr.get(i);

            current = Math.max(value, current + value);
            maxSubarray = Math.max(maxSubarray, current);

            if (value > 0) {
                maxSubsequence += value;
            }
        }

        if (maxSubsequence == arr.get(0)) {
            maxSubsequence = arr.get(0);

            for (int value : arr) {
                maxSubsequence = Math.max(maxSubsequence, value);
            }
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            List<Integer> result = maxSubarray(arr);

            System.out.println(result.get(0) + " " + result.get(1));
        }

        sc.close();
    }
}
