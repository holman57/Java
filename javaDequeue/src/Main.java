import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int u = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
            if (deque.size() > m) {
                int tmp = deque.pop();
                if (!deque.contains(tmp)) {
                    set.remove(tmp);
                }
            }
            if (deque.size() == m) {
                int Unique = set.size();
                u = Math.max(Unique, u);
            }
        }
        System.out.println(u);
    }
}