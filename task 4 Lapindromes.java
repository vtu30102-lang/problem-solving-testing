import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int n = s.length();
            int[] count = new int[26];

            for (int i = 0; i < n / 2; i++) {
                count[s.charAt(i) - 'a']++;
            }

            for (int i = (n + 1) / 2; i < n; i++) {
                count[s.charAt(i) - 'a']--;
            }

            boolean lapindrome = true;

            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    lapindrome = false;
                    break;
                }
            }

            System.out.println(lapindrome ? "YES" : "NO");
        }
    }
}
