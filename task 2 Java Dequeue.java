
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            deque.addLast(value);
            map.put(value, map.getOrDefault(value, 0) + 1);

            if (deque.size() == k) {
                maxUnique = Math.max(maxUnique, map.size());

                int removed = deque.removeFirst();
                map.put(removed, map.get(removed) - 1);

                if (map.get(removed) == 0) {
                    map.remove(removed);
                }
            }
        }

        System.out.println(maxUnique);
    }
}

