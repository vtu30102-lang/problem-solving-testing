import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            for (int i = left; i <= right; i++) {
                elements.add(matrix.get(top).get(i));
            }

            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix.get(i).get(right));
            }

            for (int i = right - 1; i >= left; i--) {
                elements.add(matrix.get(bottom).get(i));
            }

            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix.get(i).get(left));
            }

            int len = elements.size();
            int shift = r % len;

            int index = shift;

            for (int i = left; i <= right; i++) {
                matrix.get(top).set(i, elements.get(index));
                index = (index + 1) % len;
            }

            for (int i = top + 1; i <= bottom; i++) {
                matrix.get(i).set(right, elements.get(index));
                index = (index + 1) % len;
            }

            for (int i = right - 1; i >= left; i--) {
                matrix.get(bottom).set(i, elements.get(index));
                index = (index + 1) % len;
            }

            for (int i = bottom - 1; i > top; i--) {
                matrix.get(i).set(left, elements.get(index));
                index = (index + 1) % len;
            }
        }

        for (List<Integer> row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }

        matrixRotation(matrix, r);
    }
}
