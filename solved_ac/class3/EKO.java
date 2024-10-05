import java.util.*;

public class EKO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int required = sc.nextInt();
        sc.nextLine();

        int[] trees = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int low = 0, high = 1_000_000_001;
        int maxHeight = 0;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            System.out.println("low: " + low + ", high: " + high + ", mid: " + mid);
            long collected = 0;
            for (int tree : trees) {
                collected += Math.max(tree - mid, 0);
            }

            if (collected >= required) {
                maxHeight = mid;
                System.out.println("Qulified! maxHeight: " + mid);
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println(maxHeight);
    }
}